import java.util.*;
public class D_DestructionOfTheDandelionField {
     public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
   
    while(t-->0){
      int n=sc.nextInt();
      long es=0,os=0;
    
      PriorityQueue<Long> pq=new PriorityQueue<>();
    
      for(int i=0;i<n;i++){
        long v=sc.nextLong();
        
        if((v&1)==0)
            es+=v;
        else{
            pq.add(v);
            os+=v;}
      }
      long ans=0;

      if(!pq.isEmpty()){
        int rm=pq.size()/2;
        long rem=0;
        
        while(rm-->0)
        rem+=pq.poll();
        ans=os-rem+es;
      }
      System.out.println(ans);
    }
    sc.close();
  }
}


