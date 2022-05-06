public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])
                    count++;
            }
        }
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        // make a copy of k since we're going to modify it
        long currK = k;

        // generate the initial vector, just an ascending sequence
        int[] a = new int[n];
        //        for (int i = 0; i < n; i++)
        //            a[i] = i;

        int end = n - 1;
        int size = end;
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if ((currK >= size) && (currK > 0)) {
                a[i] = end - swaps;
                currK -= size;
                size--;
                swaps++;
            }
            else {
                a[i] = i - swaps;
                size--;
            }
        }

        return a;

    }

    private static void printVector(int[] v) {
        for (int i = 0; i < v.length; i++)
            StdOut.print(v[i] + " ");
        StdOut.println();

    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);

        int[] a = generate(n, k);
        printVector(a);

    }
}
