import java.util.*;
public class D_SkibidusAndSigma {
     public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            List<int[]>arrays=new ArrayList<>();
            List<Long>s=new ArrayList<>();
        
            for(int i=0;i<n;i++){
                int a[]=new int[m];
                long sum=0;
        
                for(int j=0;j<m;j++){
                    a[j]=sc.nextInt();
                    sum+=a[j];
                }
                arrays.add(a);
                s.add(sum);
             }
            Integer idx[]=new Integer[n];
 
            for(int i=0;i<n;i++) 
            idx[i]=i;
            Arrays.sort(idx,(a,b) -> Long.compare(s.get(b),s.get(a)));
            
            List<Integer> concat = new ArrayList<>();
            
            for(int i=0;i<n;i++){
                for(int v:arrays.get(idx[i]))
                concat.add(v);
            }
            long score=0;
            long prefix=0;
            
            for(int v:concat){
                prefix+=v;
                score+=prefix;
            }
            System.out.println(score);
        }
        sc.close();
    }
}
