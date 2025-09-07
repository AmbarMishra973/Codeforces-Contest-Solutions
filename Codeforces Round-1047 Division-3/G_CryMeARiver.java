import java.util.*;

public class G_CryMeARiver{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();

            List<List<Integer>> g = new ArrayList<>();
            List<List<Integer>> rg = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                g.add(new ArrayList<>());
                rg.add(new ArrayList<>());
            }

            int[] out = new int[n + 1];
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                g.get(u).add(v);
                rg.get(v).add(u);
                out[u]++;
            }

            boolean[] red = new boolean[n + 1];
            boolean[] sink = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                sink[i] = (out[i] == 0);
            }

            boolean[] f0 = new boolean[n + 1];
            boolean[] f1 = new boolean[n + 1];
            Arrays.fill(f0, true);
            Arrays.fill(f1, true);

            int[] goodSinks = new int[n + 1];
            int[] cntF1True = new int[n + 1];
            int[] cntBad = new int[n + 1];
            boolean[] hasRedChild = new boolean[n + 1];

            for (int u = 1; u <= n; u++) {
                for (int v : g.get(u)) {
                    if (sink[v]) goodSinks[u]++;
                    else cntF1True[u]++;
                }
            }

            while (q-- > 0) {
                int tp = in.nextInt();
                int u = in.nextInt();
                if (tp == 1) {
                    if (red[u]) continue;

                    boolean wasRed = red[u];
                    boolean wasF0 = f0[u];
                    boolean wasF1 = f1[u];

                    red[u] = true;
                    f0[u] = false;
                    f1[u] = false;

                    Deque<Integer> q0 = new ArrayDeque<>();
                    Deque<Integer> q1 = new ArrayDeque<>();
                    boolean[] inq0 = new boolean[n + 1];
                    boolean[] inq1 = new boolean[n + 1];

                    for (int p : rg.get(u)) {
                        if (sink[u]) {
                            goodSinks[p]--;
                        } else {
                            if (wasF1) cntF1True[p]--;
                            if (!wasF0) cntBad[p]--;
                        }

                        if (!hasRedChild[p]) {
                            hasRedChild[p] = true;
                            if (f1[p]) {
                                if (!inq1[p]) {
                                    f1[p] = false;
                                    inq1[p] = true;
                                    q1.add(p);
                                }
                            }
                        }

                        boolean nf0 = goodSinks[p] > 0 || cntF1True[p] > 0;
                        if (f0[p] && !nf0) {
                            if (!inq0[p]) {
                                f0[p] = false;
                                inq0[p] = true;
                                q0.add(p);
                            }
                        }
                    }

                    while (!q0.isEmpty() || !q1.isEmpty()) {
                        while (!q1.isEmpty()) {
                            int x = q1.poll();
                            inq1[x] = false;
                            for (int p : rg.get(x)) {
                                if (red[x] || sink[x]) continue;
                                if (cntF1True[p] > 0) cntF1True[p]--;
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

                        while (!q0.isEmpty()) {
                            int x = q0.poll();
                            inq0[x] = false;
                            for (int p : rg.get(x)) {
                                if (red[x] || sink[x]) continue;
                                cntBad[p]++;
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
                    System.out.println(f0[u] ? "YES" : "NO");
                }
            }
        }
    }
}
