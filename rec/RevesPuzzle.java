public class RevesPuzzle {

    // Let k denote the integer nearest to n+1−sqrt(2n+1)
    //
    // Transfer (recursively) the k smallest discs to a single
    // pole other than the start or destination poles.
    //
    // Transfer the remaining n−k disks to the destination pole
    // (without using the pole that now contains the smallest k discs).
    // To do so, use the algorithm for the 3-pole towers of Hanoi problem.
    //
    // Transfer (recursively) the k smallest discs to the destination pole.

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int n, String from, String temp, String to) {
        if (n == 0) return;
        hanoi(n - 1, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(n - 1, temp, from, to);
    }

    private static void hanoiC(int n, int corr, String from, String temp, String to) {
        if (n == 0) return;
        hanoiC(n - 1, corr, from, to, temp);
        StdOut.println("Move disc " + (n + corr) + " from " + from + " to " + to);
        hanoiC(n - 1, corr, temp, from, to);
    }

    private static int k(int n) {
        return (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = k(n);
        hanoi(k, "A", "C", "B");
        hanoiC(n - k, k, "A", "C", "D");
        hanoi(k, "B", "C", "D");
    }
}
