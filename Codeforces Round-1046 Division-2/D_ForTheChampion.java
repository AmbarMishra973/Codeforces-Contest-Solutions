import java.util.*;

public class D_ForTheChampion 
{
    static Scanner sc=new Scanner(System.in);
            
    static long query(char d,long k)
    {
       System.out.println("? "+d+" "+k);
       System.out.flush();

       if(!sc.hasNextLong())System.exit(0);
       long res=sc.nextLong();

       if(res==-1)System.exit(0);
       return res;
    
    }
    public static void main(String[] args)
    {
       if(!sc.hasNextInt())
       {
        sc.close();
        return;
       }

    int t=sc.nextInt();
    
    while(t-->0)
    {
       int n=sc.nextInt();
       long[] a=new long[n],b=new long[n];
       
       for(int i=0;i<n;i++)
       {
          a[i]=sc.nextLong();
          b[i]=sc.nextLong();
       }
   
       long max1=Long.MIN_VALUE,max2=Long.MIN_VALUE;
    
       for(int i=0;i<n;i++)
       {
          max1=Math.max(max1,a[i]+b[i]);
          max2=Math.max(max2,a[i]-b[i]);
       }

       long k=1_000_000_000L;
       
       query('R',k);
       query('R',k);
       query('U',k);

       long s1=query('U',k);

       query('D',k);
       query('D',k);
       query('D',k);

       long s2=query('D',k);
       long sum=s1-4*k+max1;
       long diff=s2-4*k+max2;
       long x=(sum+diff)/2;
       long y=(sum-diff)/2;

       System.out.println("! "+x+" "+y);
       System.out.flush();

        }
        sc.close();
     }
    }
