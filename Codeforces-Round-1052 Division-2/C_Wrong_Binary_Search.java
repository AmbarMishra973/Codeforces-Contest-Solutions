import java.io.*;
public class C_Wrong_Binary_Search {

    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
         int t=Integer.parseInt(br.readLine());
        
         while(t-->0){
            int n=Integer.parseInt(br.readLine());
            String s=br.readLine();
            boolean ok=true;
            int i=1;
        
            while(i<=n){
        
              if(s.charAt(i-1)=='1'){i++;continue;}
                int l=i;
        
                while(i<=n&&s.charAt(i-1)=='0')i++;
                int r=i-1;
        
                if(r-l+1==1)ok=false;
            }
                        if(!ok){sb.append("NO\n");continue;}
              int[] p=new int[n+1];
            i=1;
            
            while(i<=n){
            
              if(s.charAt(i-1)=='1'){
                p[i]=i;
                i++;
                continue;}
                  int l=i;
            
                  while(i<=n&&s.charAt(i-1)=='0')i++;
                  int r=i-1;
            
                  for(int j=l;j<r;j++)
                  p[j]=j+1;
                 p[r]=l;
            }
                        sb.append("YES\n");
            
            for(int j=1;j<=n;j++)
            
            sb.append(p[j]).append(" ");
            sb.append("\n");
        }
                System.out.print(sb.toString());
    }
  }