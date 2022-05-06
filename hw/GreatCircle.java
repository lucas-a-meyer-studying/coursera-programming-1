public class GreatCircle {

    public static void main(String[] args) {
        double x1;
        double y1;
        double x2;
        double y2;

        x1 = Math.toRadians(Double.parseDouble(args[0]));
        y1 = Math.toRadians(Double.parseDouble(args[1]));
        x2 = Math.toRadians(Double.parseDouble(args[2]));
        y2 = Math.toRadians(Double.parseDouble(args[3]));

        double distance;

        double sin1 = Math.pow(Math.sin((x2 - x1) / 2), 2);
        double sin2 = Math.pow(Math.sin((y2 - y1) / 2), 2);
        double t1 = Math.sqrt(sin1 + Math.cos(x1) * Math.cos(x2) * sin2);
        distance = 2 * 6371.0 * Math.asin(t1);

        // Prints "Hello, World" to the terminal window.
        System.out.print(distance);
        System.out.println(" kilometers");
    }

}

