import java.util.*;
 
public class A_RedStone{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0) {

            int n=sc.nextInt();
            int[] g=new int[n];

            for(int i=0;i<n;i++) {
              g[i]=sc.nextInt();
            }

            boolean f=false;
            Map<Integer,Integer>fr=new HashMap<>();

            for(int gr: g) {                
                fr.put(gr,fr.getOrDefault(gr,0)+1);

                if(fr.get(gr)>=2) {
                    f=true;
                    break;
                }
            }
            System.out.println(f?"YES":"NO");
        }
        sc.close();
    }
}


