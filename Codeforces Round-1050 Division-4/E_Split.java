import java.util.*;
public class E_Split {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n=sc.nextInt(),k=sc.nextInt();
            int[] a=new int[n];
         
            for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
            
            Map<Integer,Integer>f=new HashMap<>();
            
            for(int x:a)
            f.put(x,f.getOrDefault(x,0)+1);
            
            Map<Integer,Integer> need=new HashMap<>();
            boolean v=true;
            
            for(int x:f.keySet()){
                if(f.get(x)%k!=0)
                {v=false;
                break;}
                need.put(x,f.get(x)/k);
            }
            if(!v)
            {System.out.println(0);
            continue;}
            
            Map<Integer,Integer> cnt=new HashMap<>();
            long ans=0;
            int l=0;
            
            for(int r=0;r<n;r++){
                cnt.put(a[r],cnt.getOrDefault(a[r],0)+1);
                while(cnt.get(a[r])>need.get(a[r])){
                    cnt.put(a[l],cnt.get(a[l])-1);
                    l++;
                }
                ans+=r-l+1;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
    

