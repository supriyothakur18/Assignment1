import java.util.*;

public class ArrayTransformationCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        sc.close();

        System.out.println(minOperations(A, K));
    }

    public static long minOperations(int[] A, int K) {
        int N = A.length;

        int remainder = A[0] % K;
        for (int i = 1; i < N; i++) {
            if (A[i] % K != remainder) {
                return -1; 
            }
        }

        long[] transformed = new long[N];
        for (int i = 0; i < N; i++) {
            transformed[i] = A[i] / K;
        }

        Arrays.sort(transformed);
        long median = transformed[N / 2];

        long operations = 0;
        for (long val : transformed) {
            operations += Math.abs(val - median);
        }

        return operations;
    }
}
