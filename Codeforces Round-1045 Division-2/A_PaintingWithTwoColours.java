import java.util.*;

public class A_PaintingWithTwoColours{

    static boolean check(long n,long a,long b,long x,long L,long R){

        long l1=x,r1=x+a-1,l2=n-x-a+2,r2=n-x+1;

        if(l1>l2)
        {long t1=l1,t2=r1;l1=l2;r1=r2;l2=t1;r2=t2;}

        if(r1<l2) 
        return l1>=L&&r1<=R&&l2>=L&&r2<=R;

        boolean ok=true;  
        
        if(l1<=l2-1)
        
        if(!(l1>=L&&l2-1<=R))
         ok=false;

        if(r1+1<=r2) 

        if(!(r1+1>=L&&r2<=R))
         ok=false;
        return ok;

    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){

            long n=sc.nextLong() ,a=sc.nextLong(),b=sc.nextLong();

            if((n-b)%2!=0){

                System.out.println("NO");
                continue;}
            long y=(n-b+2)/2,L=y,R=y+b-1;

            if((n-a)%2==0){
                
                System.out.println("YES");
                continue;}

            Set<Long> s=new HashSet<>();
            s.add(1L);
            s.add(Math.max(1,n-a+1));
            List<Long> v=new ArrayList<>();  
            v.add(L);
            v.add(L-(a-1));
            v.add(R);
            v.add(R-(a-1));
            v.add(n-L+1);
            v.add(n-R+1);
            v.add(n-a-L+2);
            v.add(n-a-R+2);
            v.add((n-a+2)/2);
            v.add((n-a+3)/2);

            for(long z:v) 

            for(int d=-2;d<=2;d++) 
            s.add(z+d);

            boolean f=false;
            long xmin=1,xmax=n-a+1;

            for(long x:s){

                if(x< xmin||x> xmax)
                 continue;
                 
                 if(check(n,a,b,x,L,R))
                {f=true;
                break;}}
                
            System.out.println(f?"YES":"NO");
        }
        sc.close();
    }
}
