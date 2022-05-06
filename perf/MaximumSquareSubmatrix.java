public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int[][] max = new int[a.length][a.length];

        int maxSize = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1) {
                    // look at left, diag top left, then top
                    int min = 0;
                    if ((i != 0) && (j != 0))
                        min = Math.min(max[i - 1][j - 1], Math.min(max[i - 1][j], max[i][j - 1]));
                    max[i][j] = min + 1;
                    if (maxSize < min + 1)
                        maxSize = min + 1;
                }
                else
                    max[i][j] = 0;
            }
        }
        //        StdOut.println();
        //        printMatrix(max);
        return maxSize;
    }

    private static void printMatrix(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                StdOut.printf("%d", a[i][j]);
                if (j != a.length - 1) StdOut.print("  ");
            }
            StdOut.println();
        }
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int n = StdIn.readInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        //        printMatrix(a);
        int m = size(a);
        StdOut.printf("%d\n", m);
    }
}
