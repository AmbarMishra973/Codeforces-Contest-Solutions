import java.util.*;

public class C1_SkibidusAndFanumTax_easyversion {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();

        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            
            for(int i=0;i<n;i++){
             a[i]=sc.nextInt();
            }
            String l="";
            int k=sc.nextInt();
            a[n-1]=Math.max(a[n-1],k-a[n-1]);
            
            for(int i=n-2;i>=0;i--){
            
                if(a[i+1]>=a[i]&&a[i+1]>=k-a[i]) 
                a[i]=Math.max(a[i],k-a[i]);
            
                else if(a[i+1]>=k-a[i]) 
                a[i]=k-a[i];
            
                else if(a[i+1]<a[i]&&a[i+1]<k-a[i])
                l="NO";
            }
            System.out.println(l.equals("NO")?"NO":"YES");
         }
        sc.close();
    }    
}
