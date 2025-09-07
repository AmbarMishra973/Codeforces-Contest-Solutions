import java.util.*;

public class E_Mexification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            long k = scanner.nextLong();

            int[] arr = new int[n];
            int[] freq = new int[n + 1];  // Frequency array for elements from 0 to n

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                if (arr[i] <= n) freq[arr[i]]++;
            }

            // Find MEX: smallest number not present in arr
            int mex = 0;
            while (mex <= n && freq[mex] > 0) mex++;

            if (k == 1) {
                // If operation applied once, calculate sum after first transformation
                long sum = 0;
                int uniqueCount = 0; // count numbers that appear exactly once before mex
                for (int i = 0; i < mex; i++) {
                    if (freq[i] == 1) {
                        sum += i;
                        uniqueCount++;
                    }
                }
                // Remaining elements replaced by mex value
                sum += (long) (n - uniqueCount) * mex;
                System.out.println(sum);
                continue;
            }

            // Find the first number < mex that appears at least twice
            int doubleFreqNum = -1;
            for (int i = 0; i < mex; i++) {
                if (freq[i] >= 2) {
                    doubleFreqNum = i;
                    break;
                }
            }

            long answer;

            if (doubleFreqNum != -1) {
                // If such number exists
                long sumOfFirstD = doubleFreqNum * (doubleFreqNum - 1L) / 2;  // sum of 0 to d-1
                long remainder = n - doubleFreqNum;
                // For even k: sum = sum(0..d-1) + remainder*d
                // For odd k:  sum = sum(0..d-1) + remainder*(d+1)
                answer = (k % 2 == 0) ? sumOfFirstD + remainder * doubleFreqNum
                                      : sumOfFirstD + remainder * (doubleFreqNum + 1L);
            } else {
                // No number less than mex appears twice
                long sumOfFirstM = mex * (mex - 1L) / 2;  // sum 0..m-1
                long remainder = n - mex;
                if (remainder == 0) {
                    answer = sumOfFirstM;
                } else if (remainder == 1) {
                    answer = sumOfFirstM + mex;
                } else {
                    // For even k: sum = sum(0..m-1) + remainder*(m+1)
                    // For odd k:  sum = sum(0..m-1) + remainder*m
                    answer = (k % 2 == 0) ? sumOfFirstM + remainder * (mex + 1L)
                                          : sumOfFirstM + remainder * mex;
                }
            }

            System.out.println(answer);
        }
        scanner.close();
    }
}
