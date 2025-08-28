import java.util.Scanner;
 
public class A_InTheDream {

    static boolean check(int x,int y){
        int m=Math.max(x,y),n=Math.min(x,y);
        return m-n<=n+2;
    }
 
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
           if(!sc.hasNextInt()) {
            sc.close();
            return;
           }
           
        int t=sc.nextInt();

         while(t-->0){
               int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt(),d=sc.nextInt();

               boolean f=check(a,b);  
               boolean s=check(c-a,d-b);
              
               System.out.println((f&&s)?"YES":"NO");
        }
        sc.close();
    }
}