import java.util.*;
public class C2_SkibidusAndFanumTax_hardversion {

     public static int binsearch(int a[],int x)
{
        int l=0;
        int r=a.length-1;
        int t=-1;
    
        while(l<=r){
            int m=(l+r)/2;

            if(a[m]>=x) 
            {t=m;r=m-1;}
            
            else if(a[m]<x)
            { l=m+1;}
        }
        return t;
    } 
       public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
 
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a[]=new int[n];
            int b[]=new int[m];
      
            for(int i=0;i<n;i++) 
            a[i]=sc.nextInt();
      
            for(int i=0;i<m;i++)
             b[i]=sc.nextInt(); 
       
             Arrays.sort(b);
             int x=b[0];
             boolean ok=true;
             int p=Math.min(a[0],x-a[0]);
        
             for(int i=1;i<n;i++){ 
                 if(Math.max(b[m-1]-a[i],a[i])<p) {
                    ok=false;
                    break;
                }
                int pos=binsearch(b,p+a[i]);
                
                if(pos==-1) { 
                    p=a[i];
                }
                 else if(a[i]>=p) {
                    p=Math.min(b[pos]-a[i],a[i]);
                } 
                else {
                    p=b[pos]-a[i];
                }
        }
        System.out.println(ok?"YES":"NO");
           }
             sc.close();
      }      
}

