import java.io.*;
import java.util.*;

public class B_Merging_the_Sets {
    static FastScanner f;
    static PrintWriter o;

    public static void main(String[] a) throws IOException {

        f = new FastScanner(System.in);
          o = new PrintWriter(System.out);
        int t = f.nextInt();

        while (t-- > 0) {

            int n = f.nextInt(), m = f.nextInt();
               List<List<Integer>> b = new ArrayList<>();
             int[] c = new int[m + 1];

             for (int i = 0; i < n; i++) {
                int x = f.nextInt();
                List<Integer> g = new ArrayList<>();

                for (int j = 0; j < x; j++) {
                    int v = f.nextInt();
                    c[v]++;
                    g.add(v);
                }
                b.add(g);
            }
            boolean ok = true;

            for (int i = 1; i <= m; i++) {
                if (c[i] == 0) {
                    ok = false;
                    break;
                }            }
            if (!ok) {
                o.println("NO");
                continue;
            }    
                    int cnt = 0;

            for (List<Integer> g : b) {
                 boolean skip = true;
            
                 for (int v : g) {
                      if (c[v] == 1) {
                        skip = false;
                         break;
                    }                }
                if (skip) cnt++;
            
                if (cnt >= 2) break;
            }            o.println(cnt >= 2 ? "YES" : "NO");
        }        o.flush();
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }
        String next() throws IOException {
            
            while (st == null || !st.hasMoreTokens()) {
                String l = br.readLine();
                if (l == null) throw new NoSuchElementException();
                st = new StringTokenizer(l);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
