public class TrinomialDP {

    private static int c(int index, int size) {
        // size is by definition odd
        // 0 to size 5 should be - 2
        // 2 to size 5 should be 2
        int midpoint = size / 2;
        return index - midpoint;
    }

    public static long trinomial(int n, int k) {

        int s;
        if (k >= n)
            s = 2 * k + 1;
        else
            s = 2 * n + 1;

        long[][] coef = new long[s][s];

        // x for n, y for k
        for (int x = 0; x < s; x++) {
            for (int y = 0; y < s; y++) {
                // compute only the triangle starting on (0, 0)
                // and expanding to the right within the diagonals
                if (c(y, s) >= -c(x, s) && (c(y, s)) <= c(x, s)) {
                    // starting on converted (0, 0) and going diagonally
                    // both upwards and downwards, all coefs = 1
                    if (Math.abs(c(x, s)) == Math.abs(c(y, s))) {
                        coef[x][y] = 1;
                    }
                    else {
                        coef[x][y] = coef[x - 1][y - 1] + coef[x - 1][y] + coef[x - 1][y + 1];
                    }
                }
            }
        }

        int x = n + s / 2;
        int y = k + s / 2;
        return coef[x][y];

    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdOut.println(trinomial(n, k));
    }
}
