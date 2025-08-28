import java.util.*;
import java.math.*;

public class B_Add0orK{

    static long extGCD(long a,long b,long[] xy){

        if(b==0){
            xy[0]=1;
            xy[1]=0;
            return a;}

        long[] temp=new long[2];
        long g=extGCD(b,a%b,temp);
        xy[0]=temp[1];
        xy[1]=temp[0]-(a/b)*temp[1];
        return g; 
       }
    
        static long modInv(long a,long m){

        long[] xy=new long[2];  
        extGCD(a,m,xy);
        long x=xy[0]%m;
        return x<0?x+m:x;}

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        if(!sc.hasNextInt()){
            sc.close();
            return;}
            
        int t=sc.nextInt();  
        
        while(t-->0){

            int n=sc.nextInt();  
            long k=sc.nextLong();
            long[] arr=new long[n];

            for(int i=0;i<n;i++)
            arr[i]=sc.nextLong();

            long kk=k+1,prime=-1;

            for(long d=2;d*d<=kk;d++)
            
            if(kk%d==0){
                 prime=d; 
                 break;}

            if(prime==-1) 
            prime=kk;

            long u=(k%prime+prime)%prime;
            long v=modInv(u,prime);

            for(int i=0;i<n;i++){            
                long rem=(arr[i]%prime+prime)%prime;
                long need=(prime-rem)%prime;         
                BigInteger m=BigInteger.valueOf(need).multiply(BigInteger.valueOf(v)).mod(BigInteger.valueOf(prime));
                arr[i]+=m.longValue()*k;
            }

            for(int i=0;i<n;i++){   

                if(i>0)
                System.out.print(" ");

                System.out.print(arr[i]);

            }          
              System.out.println();

        } 
        sc.close();
       }
    }
