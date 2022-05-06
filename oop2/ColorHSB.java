public class ColorHSB {

    private int h;
    private int s;
    private int b;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if ((h < 0) || (h > 359))
            throw new IllegalArgumentException();

        if ((s < 0) || (s > 100))
            throw new IllegalArgumentException();

        if ((b < 0) || (b > 100))
            throw new IllegalArgumentException();

        this.h = h;
        this.s = s;
        this.b = b;

    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return String.format("(%d, %d, %d)", h, s, b);
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (b == 0 || s == 0)
            return true;

        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int ha = this.h - that.h;
        int hb = 360 - Math.abs(this.h - that.h);
        int h2 = Math.min(ha * ha, hb * hb);

        int s2 = (this.s - that.s) * (this.s - that.s);
        int b2 = (this.b - that.b) * (this.b - that.b);

        return h2 + s2 + b2;
    }

    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);

        int maxDist = Integer.MAX_VALUE;
        String maxName = "";

        ColorHSB base = new ColorHSB(h, s, b);

        while (!StdIn.isEmpty()) {
            String testName = StdIn.readString();
            int testH = StdIn.readInt();
            int testS = StdIn.readInt();
            int testB = StdIn.readInt();

            ColorHSB test = new ColorHSB(testH, testS, testB);
            int testDist = base.distanceSquaredTo(test);
            if (testDist < maxDist) {
                maxName = testName;
                maxName = maxName.concat(" ");
                maxName = maxName.concat(test.toString());
                maxDist = testDist;
            }
        }

        StdOut.println(maxName);

    }

}
