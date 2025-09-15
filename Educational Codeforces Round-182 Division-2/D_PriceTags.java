import java.io.*;
import java.util.*;

public class D_PriceTags{

    static FastScanner fs;
    public static void main(String[]args)throws IOException{

        fs=new FastScanner(System.in);
        int t=fs.nextInt();

        while(t-->0) 
        solve();
    }

    static void solve() throws IOException{

        int n=fs.nextInt();
        long y=fs.nextLong();
        int[] c=new int[n];
        int mx=0;

        for(int i=0;i<n;i++){
            c[i]=fs.nextInt();
            if(c[i]>mx) mx=c[i];
        }

        long[] freq=new long[mx+2];

        for(int v:c) 
        freq[v]++;

        long[] pref=new long[mx+2];

        for(int i=1;i<=mx+1;i++)
         pref[i]=pref[i-1]+freq[i];

        long ans=Long.MIN_VALUE;

        for(int x=2;x<=mx+1;x++){
            long j=0, k=0;

            for(int l=x;l<=mx+x;l+=x){

                int r = Math.min(mx+1,l);
                long p = pref[r]-pref[l-x];

                if(p>0){
                    int q = l/x;
                    j += p*q;

                    if(q<=mx)
                     k += Math.min(p,freq[q]);
                }
            }

            long income = j-(n-k)*y;

            if(income>ans) 
            ans=income;
        }

        System.out.println(ans);
    }

    static class FastScanner{
        
        BufferedReader br; StringTokenizer st;
        FastScanner(InputStream in){br=new BufferedReader(new InputStreamReader(in));}
        String next() throws IOException{
            while(st==null||!st.hasMoreTokens()){
                String l=br.readLine();
                if(l==null) throw new NoSuchElementException();
                st=new StringTokenizer(l);
            } return st.nextToken();
        }
        int nextInt() throws IOException{ return Integer.parseInt(next()); }
        long nextLong() throws IOException{ return Long.parseLong(next()); }
    }
}
