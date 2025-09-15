import java.io.*;
import java.util.*;

public class C_NonDescendingArrays{

    static FastScanner fs;
    static PrintWriter out;
    public static void main(String[]args)throws IOException{

        fs=new FastScanner(System.in);
        out=new PrintWriter(System.out);
        int t=fs.nextInt();

        while(t-->0)
        solve();
        out.flush();
    }

    static void solve()throws IOException{

        final int m=998244353;
             int n=fs.nextInt();
            int[] a=new int[n];
            int[] b=new int[n];

            for(int i=0;i<n;i++)
             a[i]=fs.nextInt();

            for(int i=0;i<n;i++) 
            b[i]=fs.nextInt();

            long[][] dp=new long[2][2];
            dp[0][0]=1; dp[0][1]=1;

            for(int i=1;i<n;i++){

                long[] ne=new long[2];

                if(a[i]>=a[i-1] && b[i]>=b[i-1])
                 ne[0]=(ne[0]+dp[(i-1)%2][0])%m;

                if(a[i]>=b[i-1] && b[i]>=a[i-1])
                 ne[0]=(ne[0]+dp[(i-1)%2][1])%m;

                if(b[i]>=a[i-1] && a[i]>=b[i-1])
                 ne[1]=(ne[1]+dp[(i-1)%2][0])%m;

                if(b[i]>=b[i-1] && a[i]>=a[i-1])
                 ne[1]=(ne[1]+dp[(i-1)%2][1])%m;

                 dp[i%2]=ne;
            }          

            long ans=(dp[(n-1)%2][0]+dp[(n-1)%2][1])%m;

            System.out.println(ans);
            } 
          
    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream in){ br=new BufferedReader(new InputStreamReader(in)); }

        String next() throws IOException{
            while(st==null||!st.hasMoreTokens()){
                String l=br.readLine();
                if(l==null) throw new NoSuchElementException();
                st=new StringTokenizer(l);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException{ return Integer.parseInt(next()); }
        long nextLong() throws IOException{ return Long.parseLong(next()); }
    }
}
