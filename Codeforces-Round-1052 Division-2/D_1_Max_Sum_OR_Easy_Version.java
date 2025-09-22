import java.io.*;
import java.util.*;
public class D_1_Max_Sum_OR_Easy_Version{

    static FastScanner fs;
    static PrintWriter out;
    public static void main(String[]args)throws IOException{
    
        fs=new FastScanner(System.in);
        out=new PrintWriter(System.out);
    
        int t=fs.nextInt();
    
        while(t-->0)solve();
        out.flush();
    }
    static void solve() throws IOException {
    
        int l=fs.nextInt(),r=fs.nextInt();
    
        int n=r-l+1;
     long sum=(long)r*(r+1);
    out.println(sum);

      TreeSet<Integer> s=new TreeSet<>();
    
      for(int i=l;i<=r;i++) 
      s.add(i);

    int mb=0,tmp=r;
     
    while(tmp>0){
        mb++;tmp>>=1;}
      mb=Math.max(mb,1);
  
    int[]res=new int[n];
   
    for(int i=0;i<n;i++){
    
        int pos=l+i,cur=findMaxXor(s,pos,mb);
         res[i]=cur;
        s.remove(cur);
    }

    for(int x:res) 
    out.print(x+" ");
    out.println();
}

static int findMaxXor(TreeSet<Integer> s,int v,int mb){
    
    int l=0,h=(1<<(mb+1))-1;
    
    for(int b=mb;b>=0;b--){
    
        int db=((v>>b)&1)^1;
            int m=1<<b,st=db==0?l:l+m,en=db==0?l+m-1:h;
    
            Integer fl=s.floor(en),ce=s.ceiling(st);
          if(fl!=null && ce!=null && ce<=en && fl>=st){
    
            if(db==1)c|=m;
             if(db==0) h=l+m-1; else l=l+m;
         }else{
            db^=1;
            if(db==1)c|=m;
              if(db==0) h=l+m-1; else l=l+m;
        }    
    }
    
        Integer res=s.floor(h);
    if(res==null||res<l) res=s.ceiling(l);
    return res;
}
 static int gcd(int a,int b){ return b==0?a:gcd(b,a%b); }
   
 static int lcm(int a,int b){ return a/gcd(a,b)*b; }
 
 static long mod=1000000007L;
 
 static long modPow(long a,long b){
        long r=1;
        a%=mod;
        while(b>0){
            if((b&1)==1) r=r*a%mod;
            a=a*a%mod;
            b>>=1;
        }
        return r;
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
