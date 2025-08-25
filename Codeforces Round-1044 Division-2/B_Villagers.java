import java.util.Scanner;
import java.util.Arrays;

public class B_Villagers  {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0) {

            int n=sc.nextInt();
            long[] g=new long[n];

            for(int i=0;i<n;i++)
             {
                g[i]=sc.nextLong();
            }         
            
            Arrays.sort(g);
            long ans=0;
            int s=(n%2==0)?1:0;

            for(int i=s;i<n;i+=2) 
            {
                ans+=g[i];
            }     
                   System.out.println(ans);

        }  
    sc.close();
  }
}

