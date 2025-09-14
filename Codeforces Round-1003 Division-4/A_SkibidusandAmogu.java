import java.util.*;
public class A_SkibidusandAmogu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
 
        while(t-->0){
            String s=sc.next();
            s=s.substring(0, s.length()-2);
            s+="i";
            System.out.println(s);
         }  
              sc.close();
    }
    
}
