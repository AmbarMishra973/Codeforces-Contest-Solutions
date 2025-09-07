import java.util.Scanner;

public class C_MaximumEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();  // Number of test cases
        
        while (testCases-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            
            boolean isAOdd = (a % 2 != 0);
            boolean isBOdd = (b % 2 != 0);
            
            // If b is odd:
            // - If a is odd, output a * b + 1 (because sum = a*b + 1 will be even)
            // - Otherwise, no even sum possible, print -1
            if (isBOdd) {
                if (isAOdd) {
                    System.out.println(a * b + 1);
                } else {
                    System.out.println(-1);
                }
                continue;
            }
            
            // Count the number of factors 2 in b
            long temp = b;
            int twoFactorCount = 0;
            while (temp % 2 == 0) {
                temp /= 2;
                twoFactorCount++;
            }
            
            // If a is odd and b has exactly one factor of 2, no even sum possible
            if (isAOdd && twoFactorCount == 1) {
                System.out.println(-1);
                continue;
            }
            
            // Try two candidates for k:
            // 1. k = 2 if a is odd, else k = 1 (to keep sum even)
            long k1 = isAOdd ? 2 : 1;
            long candidate1 = a * k1 + b / k1;
            
            // 2. k = 1 (if a is odd) or k = b / 2 otherwise (trying to maximize sum)
            // For k = b / 2, multiply a by b/2 and add 2 (since b/(b/2) = 2)
            long candidate2 = a * (b / 2) + 2;
            
            // Output the maximum of the two candidates
            System.out.println(Math.max(candidate1, candidate2));
        }
        
        scanner.close();
    }
}
