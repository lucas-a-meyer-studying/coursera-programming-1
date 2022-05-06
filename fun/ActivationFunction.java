public class ActivationFunction {


    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x < 0) return 0;
        if (x == 0) return 0.5;
        return 1;

    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x > 20) return 1.0;
        if (x < -20) return -1.0;

        double ex = Math.exp(x);
        double invx = Math.exp(-x);

        return (ex - invx) / (ex + invx);
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x == Double.POSITIVE_INFINITY) return 1.0;
        if (x == Double.NEGATIVE_INFINITY) return -1.0;

        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) return Double.NaN;

        if (x <= -2) return -1;
        if (x < 0) return x + ((x * x) / 4);
        if (x < 2) return x - ((x * x) / 4);
        return 1.0;

    }


    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);

        StdOut.print("heaviside(");
        System.out.print(x);
        System.out.print(") = ");
        System.out.println(heaviside(x));

        StdOut.print("sigmoid(");
        System.out.print(x);
        System.out.print(") = ");
        System.out.println(sigmoid(x));

        StdOut.print("tanh(");
        System.out.print(x);
        System.out.print(") = ");
        System.out.println(tanh(x));

        StdOut.print("softsign(");
        System.out.print(x);
        System.out.print(") = ");
        System.out.println(softsign(x));

        StdOut.print("sqnl(");
        System.out.print(x);
        System.out.print(") = ");
        System.out.println(sqnl(x));


    }
}
