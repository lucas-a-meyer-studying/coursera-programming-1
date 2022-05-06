public class BandMatrix {
    public static void main(String[] args) {

        int n;
        int width;

        n = Integer.parseInt(args[0]);
        width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) <= width)
                    System.out.print("*");
                else
                    System.out.print("0");
                if (j < n - 1) System.out.print("  ");

            }
            System.out.println();
        }
    }
}
