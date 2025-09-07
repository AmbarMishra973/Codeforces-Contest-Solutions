import java.util.*;

public class G_CryMeARiver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();  // Number of test cases

        while (t-- > 0) {
            int n = in.nextInt();  // Number of nodes
            int m = in.nextInt();  // Number of edges
            int q = in.nextInt();  // Number of queries

            // Graph and reverse graph adjacency lists
            List<List<Integer>> g = new ArrayList<>();
            List<List<Integer>> rg = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                g.add(new ArrayList<>());
                rg.add(new ArrayList<>());
            }

            // out[u] stores the number of outgoing edges from node u
            int[] out = new int[n + 1];
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                g.get(u).add(v);    // forward edge u -> v
                rg.get(v).add(u);   // reverse edge v -> u (for easy updates)
                out[u]++;
            }

            // red[i] = whether node i is red (losing for Cry immediately if token reaches here)
            boolean[] red = new boolean[n + 1];

            // sink[i] = whether node i is a sink node (no outgoing edges)
            boolean[] sink = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                sink[i] = (out[i] == 0);
            }

            // f0[i] and f1[i] track if node i is winning (true) or losing (false)
            // for Cry when it's Cry's turn (f0) or River's turn (f1)
            // Initially, assume all nodes are winning positions for Cry (true)
            boolean[] f0 = new boolean[n + 1];
            boolean[] f1 = new boolean[n + 1];
            Arrays.fill(f0, true);
            Arrays.fill(f1, true);

            // These counters help quickly update f0 and f1 states when colors change

            // goodSinks[u] = number of sink nodes directly reachable from u
            int[] goodSinks = new int[n + 1];

            // cntF1True[u] = number of children v of u such that f1[v] = true and v is not sink
            int[] cntF1True = new int[n + 1];

            // cntBad[u] = number of children v of u that are losing for Cry on River's turn (f1[v] == false)
            int[] cntBad = new int[n + 1];

            // hasRedChild[u] = whether node u has a child that is red (so losing for Cry immediately)
            boolean[] hasRedChild = new boolean[n + 1];

            // Initialize counters based on the graph structure and sink nodes
            for (int u = 1; u <= n; u++) {
                for (int v : g.get(u)) {
                    if (sink[v]) {
                        goodSinks[u]++;
                    } else {
                        cntF1True[u]++;
                    }
                }
            }

            // Process queries
            while (q-- > 0) {
                int tp = in.nextInt();  // Query type
                int u = in.nextInt();   // Node in query

                if (tp == 1) {
                    // Query type 1: Paint node u red

                    if (red[u]) {
                        // Already red, no changes needed
                        continue;
                    }

                    // Before update: store previous states for use in counters update
                    boolean wasF0 = f0[u];
                    boolean wasF1 = f1[u];

                    // Mark u as red => immediately losing for Cry regardless of turn
                    red[u] = true;
                    f0[u] = false;
                    f1[u] = false;

                    // Queues for BFS-like propagation of state changes
                    Deque<Integer> q0 = new ArrayDeque<>();
                    Deque<Integer> q1 = new ArrayDeque<>();

                    // Track which nodes are already in these queues (to avoid duplicates)
                    boolean[] inq0 = new boolean[n + 1];
                    boolean[] inq1 = new boolean[n + 1];

                    // For all parents p of u, update counters and propagate state changes if needed
                    for (int p : rg.get(u)) {
                        if (sink[u]) {
                            // u was a sink before becoming red, reduce count of good sinks for p
                            goodSinks[p]--;
                        } else {
                            // u was not a sink before, update counters accordingly
                            if (wasF1) cntF1True[p]--;
                            if (!wasF0) cntBad[p]--;
                        }

                        // Now p has at least one red child (u)
                        if (!hasRedChild[p]) {
                            hasRedChild[p] = true;
                            if (f1[p]) {
                                // If f1[p] was true (winning for Cry on River's turn), 
                                // but now p has a red child => f1[p] becomes false (losing)
                                if (!inq1[p]) {
                                    f1[p] = false;
                                    inq1[p] = true;
                                    q1.add(p);
                                }
                            }
                        }

                        // Calculate new state for f0[p] (winning for Cry on Cry's turn)
                        boolean nf0 = goodSinks[p] > 0 || cntF1True[p] > 0;

                        // If previously f0[p] was true but now no good sinks or children with f1 true,
                        // p becomes losing for Cry on Cry's turn
                        if (f0[p] && !nf0) {
                            if (!inq0[p]) {
                                f0[p] = false;
                                inq0[p] = true;
                                q0.add(p);
                            }
                        }
                    }

                    // Propagate changes through the graph until no more updates are possible
                    while (!q0.isEmpty() || !q1.isEmpty()) {
                        // Process nodes where f1 changed from true to false
                        while (!q1.isEmpty()) {
                            int x = q1.poll();
                            inq1[x] = false;
                            for (int p : rg.get(x)) {
                                // If x is red or a sink, skip as no update needed further up
                                if (red[x] || sink[x]) continue;

                                // Decrease count of children with f1 true
                                if (cntF1True[p] > 0) cntF1True[p]--;

                                // Check if f0[p] needs update
                                boolean nf0 = goodSinks[p] > 0 || cntF1True[p] > 0;
                                if (f0[p] && !nf0) {
                                    if (!inq0[p]) {
                                        f0[p] = false;
                                        inq0[p] = true;
                                        q0.add(p);
                                    }
                                }
                            }
                        }

                        // Process nodes where f0 changed from true to false
                        while (!q0.isEmpty()) {
                            int x = q0.poll();
                            inq0[x] = false;
                            for (int p : rg.get(x)) {
                                if (red[x] || sink[x]) continue;

                                // Increase count of bad children (children losing for Cry on River's turn)
                                cntBad[p]++;

                                // If p has no red children, but now has bad children and f1[p] was true,
                                // f1[p] becomes false
                                if (!hasRedChild[p] && f1[p] && cntBad[p] > 0) {
                                    if (!inq1[p]) {
                                        f1[p] = false;
                                        inq1[p] = true;
                                        q1.add(p);
                                    }
                                }
                            }
                        }
                    }

                } else {
                    // Query type 2: Check if Cry wins starting at node u
                    // Cry wins if f0[u] is true (winning position on Cry's turn)
                    System.out.println(f0[u] ? "YES" : "NO");
                }
            }
        }
        in.close();
    }
}
