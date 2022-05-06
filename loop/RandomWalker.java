public class RandomWalker {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int maxDist;
        int dist;
        int steps = 0;

        maxDist = Integer.parseInt(args[0]);

        dist = Math.abs(x) + Math.abs(y);
        while (dist < maxDist) {
            System.out.printf("(%d, %d)\n", x, y);
            double rnd = Math.random();
            if (rnd < 0.25) x++;
            else if (rnd < 0.5) y++;
            else if (rnd < 0.75) x--;
            else y--;

            steps++;

            dist = Math.abs(x) + Math.abs(y);
        }
        System.out.printf("(%d, %d)\n", x, y);
        System.out.printf("steps = %d\n", steps);
    }
}
