import java.util.*;
public class E_SkibidusAndRizz {
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            StringBuilder sb=new StringBuilder();

            if(k<=Math.max(n,m)&&k>=Math.abs(n-m))
            {
                if(n>m){
                    sb.append("0".repeat(k));
                    sb.append("10".repeat(n-k));
                    sb.append("1".repeat(m-n+k));
                }
                else{
                    sb.append("1".repeat(k));
                    sb.append("01".repeat(m-k));
                    sb.append("0".repeat(n-m+k));
                }
                System.out.println(sb);
            }
            else
            System.out.println(-1);
        }
           sc.close();
    }      
}
