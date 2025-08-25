import java.util.*;

public class A_Homework {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){

            @SuppressWarnings("unused")
            int n=sc.nextInt();
            String s=sc.next();
            int m=sc.nextInt();
            String a=sc.next();
            String b=sc.next();
            String r="";

            for(int i=0;i<m;i++){

                if(b.charAt(i)=='D')
                 s+=a.charAt(i);
                else 
                 {r+=a.charAt(i)+s;
                    s=r;r="";
                }
            }
System.out.println(s);
        }
        sc.close();
    }
}
