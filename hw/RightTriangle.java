public class RightTriangle {

    public static void main(String[] args) {
        int a;
        int b;
        int c;

        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        c = Integer.parseInt(args[2]);

        boolean match;

        match = a * a == b * b + c * c;
        match = match || b * b == a * a + c * c;
        match = match || c * c == a * a + b * b;

        match = match && (a > 0) && (b > 0) && (c > 0);

        // Prints "Hello, World" to the terminal window.
        System.out.println(match);
    }

}
