import java.util.*;

public class D_ReplaceWithOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = scanner.nextInt();  // Number of test cases
        
        while (testCases-- > 0) {
            int n = scanner.nextInt();      // Size of array b
            
            int[] b = new int[n];           // Input array b
            int[] a = new int[n];           // Result array a
            
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            
            // Map from value in b -> list of indices where it appears
            Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
            
            for (int i = 0; i < n; i++) {
                valueToIndices.computeIfAbsent(b[i], k -> new ArrayList<>()).add(i);
            }
            
            // Check if the number of occurrences of each value is divisible by that value itself
            // Otherwise, no valid array a can be constructed
            boolean isValid = true;
            for (Map.Entry<Integer, List<Integer>> entry : valueToIndices.entrySet()) {
                int value = entry.getKey();
                int occurrences = entry.getValue().size();
                if (occurrences % value != 0) {
                    isValid = false;
                    break;
                }
            }
            
            if (!isValid) {
                System.out.println(-1);
                continue;
            }
            
            // Assign labels for each group of indices with the same b[i]
            // Each group size is multiple of b[i], so split into blocks of size b[i]
            int currentLabel = 1;
            for (Map.Entry<Integer, List<Integer>> entry : valueToIndices.entrySet()) {
                int blockSize = entry.getKey();
                List<Integer> indices = entry.getValue();
                int totalIndices = indices.size();
                
                for (int i = 0; i < totalIndices; ) {
                    // Assign the same label to the next blockSize elements
                    for (int j = 0; j < blockSize; j++) {
                        a[indices.get(i++)] = currentLabel;
                    }
                    currentLabel++;
                }
            }
            
            // Output the resulting array a
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < n; i++) {
                output.append(a[i]);
                if (i != n - 1) output.append(" ");
            }
            System.out.println(output);
        }
        
        scanner.close();
    }
}
