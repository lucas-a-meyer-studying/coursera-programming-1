public class Birthday {
    public static void main(String[] args) {

        int size = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        int[] cumSum = new int[size * 3];

        for (int t = 0; t < trials; t++) {
            int[] birthdays = new int[size];
            boolean stop = false;
            int i = 0;
            while (!stop) {
                int rndPick = (int) (Math.random() * size);
                if (birthdays[rndPick] == 1) {
                    cumSum[i]++;
                    stop = true;
                }
                else birthdays[rndPick] = 1;
                i++;
            }
        }

        int i = 0;
        boolean stop = false;
        double perc = 0;
        while (!stop) {
            perc += (double) cumSum[i] / trials;
            System.out.printf("%d\t%d\t%f\n", i + 1, cumSum[i], perc);
            i++;
            if ((perc >= 0.5) || (i >= cumSum.length - 1))
                stop = true;
        }
    }
}
