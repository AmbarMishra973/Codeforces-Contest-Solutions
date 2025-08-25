import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B_TheSecretNumber {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){

            long n=sc.nextLong();
            long k=10;long c=0;ArrayList<Long>l=new ArrayList<>();

            while(n/(k+1)!=0){

                if(n%(k+1)==0)
                {
                    c++;
                    l.add(n/(k+1));
                }
                k*=10;
            }

System.out.println(c);
Collections.sort(l);

if(l.size()>0)
{
    for(int i=0;i<l.size();i++)
    
    System.out.print(l.get(i)+" ");
    
    System.out.println();
        }
    }
    sc.close();
    }
    
}
