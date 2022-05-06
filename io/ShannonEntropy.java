public class ShannonEntropy {
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        int[] draws = StdIn.readAllInts();

        int[] counts = new int[max + 1];
        for (int i = 0; i < draws.length; i++) {
            counts[draws[i]]++;
        }

        double entropy = 0.0;
        for (int i = 1; i < counts.length; i++) {
            double p = ((double) counts[i]) / draws.length;
            double logp;
            if (p == 0)
                logp = 0;
            else
                logp = -Math.log(p) / Math.log(2);
            entropy += p * logp;
        }
        StdOut.printf("%.4f\n", entropy);
    }
}
