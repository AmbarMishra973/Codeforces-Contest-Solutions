import java.util.*;

public class C1_TheCunningSeller_Easy_ {    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0)
            {   
            long c=0;
            long n=sc.nextLong();

            while(n>0) 
               {
               long x = (long)(Math.log((double)n) / Math.log(3.0) + 1e-10);
               n-=(long)(Math.pow(3,x));              
               c+=(long)(Math.pow(3,x+1)+x*(Math.pow(3,x-1)));
               }    

System.out.println(c);
            }

sc.close();

    }
}

