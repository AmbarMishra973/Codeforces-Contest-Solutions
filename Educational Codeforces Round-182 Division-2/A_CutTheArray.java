import java.io.*;
import java.util.*;

public class A_CutTheArray{

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
      int []a=new int[n];

    for(int i=0;i<n;i++)
    a[i]=fs.nextInt();

      int[]p=new int[n+1];

    for(int i=0;i<n;i++)
    p[i+1]=(p[i]+a[i])%3;

      boolean f=false;
      int L=0,R=0;

    for(int l=1;l<n&&!f;l++){

        for(int r=l+1;r<n&&!f;r++){
            int x=p[l],y=(p[r]-p[l]+3)%3,z=(p[n]-p[r]+3)%3;

            if(valid(x,y,z)){
                L=l;
                R=r;
                f=true;}
        }
    }
    if(f)
    out.println(L+" "+R);
    else
     out.println("0 0");
}
static boolean valid(int x,int y,int z){

    return (x==y&&y==z)||(x!=y&&y!=z&&x!=z);
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
