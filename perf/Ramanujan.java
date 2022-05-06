public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        // the largest number that can participate on the solution
        // is floor(pow(n, 1/3))
        long d = (long) Math.cbrt(n);
        int count = 0;
        long previous = 0;

        for (long a = 1; a <= d; a++) {
            //            StdOut.printf("a = %d, d = %d\n", a, d);
            double a3 = a * a * a;
            double b = Math.cbrt(n - a3);
            long lb = (long) b;
            long lb3 = lb * lb * lb;
            long lb1 = lb + 1;
            long lb13 = lb1 * lb1 * lb1;
            long n1 = n - lb13;
            long n2 = n - lb3;
            if ((n1 == a3) || (n2 == a3)) {
                if ((lb != previous) && (lb1 != previous)) {
                    count++;
                    previous = a;
                }
            }
            if (count == 2)
                break;
        }

        return (count == 2);

    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);

        if (isRamanujan(n)) StdOut.println("true");
        else StdOut.println(false);

    }
}
