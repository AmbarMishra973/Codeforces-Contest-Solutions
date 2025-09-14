import java.util.*;
public class C_Pacer {
      public static void main(String[] args){
  
        Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
  
          while(t-->0)
          {
            int n=sc.nextInt(),m=sc.nextInt();
  
            int[] a=new int[n+1];
            int[] b=new int[n+1];
  
            a[0]=0; b[0]=0; 
  
            for(int i=1;i<=n;i++){
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
           
            long ans=0;
           
            for(int i=0;i<n;i++){
                int l=a[i+1]-a[i];
                int n1=b[i]^b[i+1];
                
                if((l%2)!=n1)
                 ans+=l-1;
                else ans+=l;
            }
                    ans+=m-a[n];
            System.out.println(ans);
        }
        sc.close();
    }
}


