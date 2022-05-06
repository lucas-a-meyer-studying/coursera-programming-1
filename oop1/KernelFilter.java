import java.awt.Color;

public class KernelFilter {

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = 1 / 16.0;
        weights[0][1] = 2 / 16.0;
        weights[0][2] = 1 / 16.0;
        weights[1][0] = 2 / 16.0;
        weights[1][1] = 4 / 16.0;
        weights[1][2] = 2 / 16.0;
        weights[2][0] = 1 / 16.0;
        weights[2][1] = 2 / 16.0;
        weights[2][2] = 1 / 16.0;

        return convolute(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = 0.0;
        weights[0][1] = -1.0;
        weights[0][2] = 0.0;
        weights[1][0] = -1.0;
        weights[1][1] = 5.0;
        weights[1][2] = -1.0;
        weights[2][0] = 0.0;
        weights[2][1] = -1.0;
        weights[2][2] = 0.0;

        return convolute(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = -1.0;
        weights[0][1] = -1.0;
        weights[0][2] = -1.0;
        weights[1][0] = -1.0;
        weights[1][1] = 8.0;
        weights[1][2] = -1.0;
        weights[2][0] = -1.0;
        weights[2][1] = -1.0;
        weights[2][2] = -1.0;

        return convolute(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = new double[3][3];
        weights[0][0] = -2.0;
        weights[0][1] = -1.0;
        weights[0][2] = 0;
        weights[1][0] = -1.0;
        weights[1][1] = 1.0;
        weights[1][2] = 1.0;
        weights[2][0] = 0.0;
        weights[2][1] = 1.0;
        weights[2][2] = 2.0;

        return convolute(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = new double[9][9];
        for (int i = 0; i < 9; i++)
            weights[i][i] = 1 / 9.0;

        return convolute(picture, weights);
    }

    private static int convert(int n, int range) {
        //      StdOut.printf("Convert was called with n = %d, range = %d", n, range);

        int ret;
        if (n < 0) {
            ret = (range + n) % range;
        }
        else if (n >= range) {
            ret = n % range;
        }
        else ret = n;

        //    StdOut.printf(" ... returning %d\n", ret);
        return ret;

    }

    private static Picture convolute(Picture picture, double[][] weights) {

        Picture result = new Picture(picture);
        int width = picture.width();
        int height = picture.height();

        int kernelWidth = weights.length;
        int adj = weights.length / 2;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //                StdOut.printf("Getting pixel at col = %d, row = %d\n", i, j);
                double r = 0.0;
                double g = 0.0;
                double b = 0.0;
                for (int w = -adj; w <= adj; w++) {
                    for (int h = -adj; h <= adj; h++) {
                        int adjW = convert(i + w, width);
                        int adjH = convert(j + h, height);

                        //                      StdOut.printf("\tGetting kernel at col = %d, row = %d\n", adjW, adjH);
                        Color pixel = picture.get(adjW, adjH);

                        //                        StdOut.printf("\tGetting weights at row= %d, col = %d\n", w + adj, h + adj);
                        r += pixel.getRed() * weights[w + adj][h + adj];
                        g += pixel.getGreen() * weights[w + adj][h + adj];
                        b += pixel.getBlue() * weights[w + adj][h + adj];


                    }
                }
                r = Math.round(r);
                if (r < 0) r = 0;
                if (r > 255) r = 255;

                g = Math.round(g);
                if (g < 0) g = 0;
                if (g > 255) g = 255;

                b = Math.round(b);
                if (b < 0) b = 0;
                if (b > 255) b = 255;

                Color newPixel = new Color((int) r, (int) g, (int) b);
                result.setRGB(i, j, newPixel.getRGB());
            }
        }

        return result;

    }

    // Test client (ungraded).
    public static void main(String[] args) {

        String filename = args[0];

        Picture p = new Picture(filename);
        StdOut.printf("width = %d, height = %d\n", p.width(), p.height());
        // p.show();
        Picture adj;
        // adj = sharpen(p);
        // adj = motionBlur(p);
        // adj = laplacian(p);
        // adj = gaussian(p);
        adj = emboss(p);
        adj.show();
        // System.out.println("Motion blur");
        // Picture mbP = motionBlur(p);

        //mbP.show();

    }

}
