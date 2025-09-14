import java.util.*;
public class B_Lasers {
       public static void main(String[] args) {
   
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
   
        while(t-->0)
        {
          int n=sc.nextInt();
          int m=sc.nextInt();
          int x=sc.nextInt();
          int y=sc.nextInt();
   
          int a[]=new int[n];
          int b[]=new int[m];
   
          for(int i=0;i<n;i++) 
          a[i]=sc.nextInt();
          
          for(int i=0;i<m;i++) 
          b[i]=sc.nextInt();
          
          int ch=0,cv=0;
          
          for(int i=0;i<n;i++)
           if(a[i]<y)
            ch++;

          for(int i=0;i<m;i++) 
          if(b[i]<x)
           cv++;
          
        System.out.println(Math.min(m+ch,n+cv));
        }
        sc.close();
    }
}


