public class CMYKtoRGB {

    public static void main(String[] args) {
        double cyan;
        double magenta;
        double yellow;
        double black;

        cyan = Double.parseDouble(args[0]);
        magenta = Double.parseDouble(args[1]);
        yellow = Double.parseDouble(args[2]);
        black = Double.parseDouble(args[3]);

        double white = 1 - black;
        long red = Math.round(255 * white * (1 - cyan));
        long green = Math.round(255 * white * (1 - magenta));
        long blue = Math.round(255 * white * (1 - yellow));

        // Prints "Hello, World" to the terminal window.
        System.out.printf("red = %d\n", red);
        System.out.printf("green = %d\n", green);
        System.out.printf("blue = %d\n", blue);

    }

}
