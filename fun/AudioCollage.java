public class AudioCollage {

    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }

        return b;

    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            b[a.length - i - 1] = a[i];
        }

        return b;

    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double[] c = new double[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            c[a.length + i] = b[i];
        }
        return c;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        int max = Math.max(a.length, b.length);
        double[] c = new double[max];

        if (a.length == max) {
            for (int i = 0; i < a.length; i++) {
                if (i < b.length) c[i] = a[i] + b[i];
                else c[i] = a[i];
            }
        }
        else { // b is bigger
            for (int i = 0; i < b.length; i++) {
                if (i < a.length) c[i] = a[i] + b[i];
                else c[i] = b[i];
            }
        }
        return c;


    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        int newSize = (int) (a.length / alpha);

        double[] c = new double[newSize];

        int i = 0;
        while (i < newSize) {
            int j = (int) (i * alpha);
            c[i] = a[j];
            i++;
        }

        return c;
    }

    private static double[] normalize(double[] a) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;

        double[] b = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }

        for (int i = 0; i < a.length; i++) {
            double scale = max - min;
            b[i] = (a[i] - min) / scale;
        }

        return b;
    }

    private static boolean hasNaN(double[] a) {

        boolean ret = false;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (Double.isNaN(a[i])) {
                StdOut.printf("Found NaN @ position %d\n", i);
                ret = true;
                count++;
                if (count > 10) break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("beatbox.wav");
        double[] buzzer = StdAudio.read("buzzer.wav");
        double[] cow = StdAudio.read("cow.wav");
        double[] dialup = StdAudio.read("dialup.wav");
        double[] chimes = StdAudio.read("chimes.wav");

        double[] cowwoc = merge(cow, reverse(cow));
        double[] music = mix(cowwoc, beatbox);
        music = mix(music, changeSpeed(chimes, 2));
        music = mix(music, amplify(dialup, 0.01));
        music = mix(music, amplify(buzzer, 0.01));

        StdAudio.play(normalize(music));
    }
}
