import java.util.Scanner;

public class A_CollatzConjecture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();  // Number of test cases
        
        while (testCases-- > 0) {
            int steps = scanner.nextInt();    // Number of Collatz steps (k)
            int finalValue = scanner.nextInt(); // Final value after k steps (x)
            
            // Calculate any valid initial value by reversing all divisions by 2
            // i.e., multiply finalValue by 2^steps
            int possibleInitial = finalValue << steps;
            
            // Print the result
            System.out.println(possibleInitial);
        }
        
        scanner.close();
    }
}
