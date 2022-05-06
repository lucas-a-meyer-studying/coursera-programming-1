public class DiscreteDistribution {

    public static void main(String[] args) {

        int[] intervals = new int[args.length];
        intervals[0] = 0;
        int draws = Integer.parseInt(args[0]);

        for (int i = 1; i < args.length; i++) {
            intervals[i] = intervals[i - 1] + Integer.parseInt(args[i]);
        }

        int max = intervals[intervals.length - 1];


        for (int d = 0; d < draws; d++) {
            // want to pick an integer between 0 and (max - 1)
            int rndPick = (int) (Math.random() * max);

            for (int i = 1; i < intervals.length; i++) {
                if (rndPick < intervals[i]) {
                    System.out.printf("%d ", i);
                    break;
                }
            }
        }
        System.out.println();
    }
}
