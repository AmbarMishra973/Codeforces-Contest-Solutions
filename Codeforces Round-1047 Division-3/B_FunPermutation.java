import java.util.Scanner;

public class B_FunPermutation{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();  // Number of test cases
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();       // Size of permutation
            
            int[] p = new int[n];             // Input permutation p
            int[] q = new int[n];             // Output permutation q
            
            // Read permutation p
            for (int i = 0; i < n; i++) {
                p[i] = scanner.nextInt();
            }
            
            // Construct permutation q where q[i] = n + 1 - p[i]
            // This ensures p[i] + q[i] = n + 1 for all i
            for (int i = 0; i < n; i++) {
                q[i] = n + 1 - p[i];
            }
            
            // Print permutation q
            for (int i = 0; i < n; i++) {
                System.out.print(q[i]);
                if (i < n - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();  // New line after each test case
        }
        
        scanner.close();
    }
}
