import java.util.*;
 
public class C_AgainstTheDifference {
    public static void main(String[] args){

       Scanner s=new Scanner(System.in);

       int t=s.nextInt();

       while(t-->0)
       {
         int n=s.nextInt();
         int[] x=new int[n];

         for(int i=0;i<n;i++)
         x[i]=s.nextInt();
           
         List<List<Integer>> m=new ArrayList<>();

         for(int i=0;i<=n;i++)
         m.add(new ArrayList<>());

         for(int i=0;i<n;i++)
         m.get(x[i]).add(i);

         List<int[]> segs=new ArrayList<>();

         for(int v=1;v<=n;v++)
         {
             List<Integer> z=m.get(v);
             int c=z.size();

             for(int j=v;j<=c;j++)
             segs.add(new int[]{z.get(j-v),z.get(j-1),v}); 

         }

         if(segs.isEmpty())
         {
             System.out.println(0);
             continue;
         }

         segs.sort((a,b)->a[1]!=b[1]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
         int d=segs.size();
         int[] a=new int[d],b=new int[d],c=new int[d],dp=new int[d+1];
                      
         for(int i=0;i<d;i++)
         {
          a[i]=segs.get(i)[0];
          b[i]=segs.get(i)[1];
          c[i]=segs.get(i)[2];
         }
        
         for(int i=1;i<=d;i++)
         {
          int p=lb(b,a[i-1]);
          dp[i]=Math.max(dp[i-1],dp[p]+c[i-1]);
         }
         
         System.out.println(dp[d]);
         
        }
        s.close();
     }
 
    static int lb(int[] a,int k)
    {

       int l=0,r=a.length;
      
       while(l<r)
       {
         int m=(l+r)>>1; 
         if(a[m]<k)
           l=m+1;
         else
           r=m;
        
        }

        return l;
     
    }
}