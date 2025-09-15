import java.io.*;
import java.util.*;

public class B_MaximumCostPermutation{

    static FastScanner fs;
    static PrintWriter out;

    public static void main(String[]args)throws IOException{

        fs=new FastScanner(System.in);
        out=new PrintWriter(System.out);
        int t=fs.nextInt();
        while(t-->0)solve();
        out.flush();
    }
    
    static void solve()throws IOException{
    
        int n=fs.nextInt();
    int[]a=new int[n+1];

    Set<Integer>s=new HashSet<>(),m=new HashSet<>();
    List<Integer>z=new ArrayList<>(),miss=new ArrayList<>();
    
    for(int i=1;i<=n;i++){
        a[i]=fs.nextInt();
        
        if(a[i]==0)
        z.add(i);
       
        else 
        s.add(a[i]);
    }
    
    for(int i=1;i<=n;i++)

    if(!s.contains(i))
    miss.add(i);
    
    for(int i=1;i<=n;i++)

    if(a[i]!=0&&a[i]==i)
    m.add(i);
    
    if(z.size()==1&&miss.size()==1&&miss.get(0).equals(z.get(0)))
    m.add(z.get(0));
    
    int L=-1,R=-1;

    for(int i=1;i<=n;i++){
        if(!m.contains(i)){
            L=i;
            break;}}

    if(L==-1){
        out.println(0);
        return;}

    for(int i=n;i>=1;i--){
        if(!m.contains(i)){
            R=i;
            break;}}
            
    out.println(R-L+1);
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
