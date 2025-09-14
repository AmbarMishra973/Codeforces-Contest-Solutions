import java.util.*;
public class B_SkibidusAndOhio {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
      
        while(t-->0){
            String s=sc.next();
            int n=s.length();
            int c=0;
      
            for(int i=0;i<n-1;i++){
                if(s.charAt(i)==s.charAt(i+1)){
                    c++;
                    break;
                }
            }
              System.out.println((c==1)?1:n);
        }
                sc.close();
    }
}
