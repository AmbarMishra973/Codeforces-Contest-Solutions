import java.util.*;
 
public class B_LikeTheBitset {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        if(!sc.hasNextInt()){
            sc.close();
            return;
        }
        
        int t=sc.nextInt();

        while(t-->0){

            int len=sc.nextInt(),limit=sc.nextInt();
            String str=sc.next();
            int cnt=0;
            boolean fail=false;
            for(int i=0;i<str.length();i++){ 
                
                if(str.charAt(i)=='1'){

                    cnt++;

                    if(cnt>=limit){
                        
                        fail=true;
                        break;
                    }
                }
                else 
                
                cnt=0;
            
            }

                if(fail)
                {
                System.out.println("NO");
                continue;
                }
                System.out.println("YES");
                int[] res=new int[len];
                List<Integer> z=new ArrayList<>(),o=new ArrayList<>();
             
                for(int i=0;i<len;i++){

                if(str.charAt(i)=='0')
                z.add(i);
                  
                else
                o.add(i); 
            
            }
            
            int assign=len;

            for(int i:z)
            res[i]=assign--;
            
            for(int i:o)
            res[i]=assign--;
            
            for(int i=0;i<len;i++){

                if(i>0)System.out.print(" ");

     System.out.print(res[i]);
            }
            System.out.println();

        } 
    sc.close();
}
}