import java.io.*;
import java.util.*;

public class A_Equal_Occurrences{

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
      
        int n=fs.nextInt();
         int[]a=new int[n];
        Map<Integer,Integer> f=new HashMap<>();
      
        for(int i=0;i<n;i++){
            a[i]=fs.nextInt();
            f.put(a[i],f.getOrDefault(a[i],0)+1);
        }
        int res=0;
      
        for(int k=1;k<=n;k++){
            int c=0;
      
            for(int v:f.values())if(v>=k)c++;
            res=Math.max(res,c*k);
        }
        out.println(res);
    }
    
    static int gcd(int a,int b){return b==0?a:gcd(b,a%b);}
    static int lcm(int a,int b){return a/gcd(a,b)*b;}
    static long mod=1000000007L;
    static long modPow(long a,long b){
        long r=1;a%=mod;
    
        while(b>0){
            if((b&1)==1)r=r*a%mod;
            a=a*a%mod;
            b>>=1;
        }
        return r;
    }
    static class FastScanner{
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream in){br=new BufferedReader(new InputStreamReader(in));}
        String next() throws IOException{
    
            while(st==null||!st.hasMoreTokens()){
                String l=br.readLine();
                if(l==null)throw new NoSuchElementException();
                st=new StringTokenizer(l);
            }
            return st.nextToken();
        }
        int nextInt() throws IOException{return Integer.parseInt(next());}
        long nextLong() throws IOException{return Long.parseLong(next());}
    }
}
