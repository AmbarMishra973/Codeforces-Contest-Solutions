import java.util.*;
public class F_GravityFalls {
        public static void main(String[]a){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();

        while(t-->0){
            int n=s.nextInt();
            int[][] arr=new int[n][];
            int max=0;
        
            for(int i=0;i<n;i++){
                int k=s.nextInt();
                arr[i]=new int[k];
          
                for(int j=0;j<k;j++)
                 arr[i][j]=s.nextInt();
                
                 if(k>max)
                  max=k;
            }
            int cur=0;
            StringBuilder sb=new StringBuilder();
            while(cur<max){
                int best=-1;
                
                for(int i=0;i<n;i++){
                    
                    if(arr[i].length<=cur)
                     continue;
                    
                     if(best==-1){
                        best=i;
                    }
                    else{
                        int x=cur,y=cur;
                        
                        while(x<arr[i].length&&y<arr[best].length&&arr[i][x]==arr[best][y])
                        {x++;
                            y++;
                        }
                        
                        if(x==arr[i].length&&y==arr[best].length) 
                        continue;
                        
                        if(x==arr[i].length||(y<arr[best].length && arr[i][x]<arr[best][y]))
                         best=i;
                    }
                }
                
                for(int k=cur;k<arr[best].length;k++) 
                sb.append(arr[best][k]).append(" ");
                cur=arr[best].length;
            }
            if(sb.length()>0) 
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
        s.close();
    }
}

