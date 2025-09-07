import java.util.*;

public class F_PrefixMaximumInvariance {
    // Custom Binary Indexed Tree (Fenwick Tree) for range max queries
    static class BITree {
        int size;
        int[] tree;

        BITree(int maxSize) {
            size = maxSize;
            tree = new int[maxSize + 5];
        }

        // Update BIT at position `index` with value `val` (keep max)
        void update(int index, int val) {
            while (index <= size) {
                tree[index] = Math.max(tree[index], val);
                index += index & -index;
            }
        }

        // Query max value in range [1...index]
        int getMax(int index) {
            int result = 0;
            while (index > 0) {
                result = Math.max(result, tree[index]);
                index -= index & -index;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();

            int[] a = new int[n];  // Array a
            int[] b = new int[n];  // Array b

            for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
            for (int i = 0; i < n; i++) b[i] = scanner.nextInt();

            int maxValue = 2 * n + 2;
            BITree bit = new BITree(maxValue);

            long totalMatch = 0;  // Total value of f(x, y)
            long overcountAdjust = 0;

            for (int i = 0; i < n; i++) {
                int ai = a[i];
                int bi = b[i];

                int revA = maxValue - ai;
                int revB = maxValue - bi;

                // max prefix position where a[i] or greater was seen (via BIT)
                int lastPosOfA = bit.getMax(revA);

                // update current a[i] into BIT
                bit.update(revA, i + 1);  // BIT stores 1-based indices

                int greaterPosInB = bit.getMax(revB);  // for current b[i]

                long suffixLength = n - i;
                totalMatch += suffixLength * greaterPosInB;

                // If b[i] < a[i], it will fail to match the required prefix max
                if (bi < ai) {
                    overcountAdjust += suffixLength * ((i + 1) - lastPosOfA);
                }
            }

            System.out.println(totalMatch - overcountAdjust);
        }

        scanner.close();
    }
}
