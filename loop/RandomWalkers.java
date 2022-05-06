public class RandomWalkers {

    public static void main(String[] args) {

        int sims;
        double cumSteps = 0.0;
        int maxDist;

        maxDist = Integer.parseInt(args[0]);
        sims = Integer.parseInt(args[1]);

        for (int s = 0; s < sims; s++) {
            int x = 0;
            int y = 0;
            int dist;
            int steps = 0;


            dist = Math.abs(x) + Math.abs(y);
            while (dist < maxDist) {
                double rnd = Math.random();
                if (rnd < 0.25) x++;
                else if (rnd < 0.5) y++;
                else if (rnd < 0.75) x--;
                else y--;

                steps++;
                dist = Math.abs(x) + Math.abs(y);
            }
            cumSteps += steps;
        }

        System.out.print("average number of steps = ");
        System.out.println(cumSteps / sims);

    }

}
