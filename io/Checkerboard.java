import java.awt.Color;

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        StdDraw.setScale(0, n);

        StdDraw.setPenColor(StdDraw.BLUE);
        Color lastRowStart = StdDraw.getPenColor();
        for (int i = 0; i < n; i++) {
            lastRowStart = StdDraw.getPenColor();
            for (int j = 0; j < n; j++) {
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                if (StdDraw.getPenColor().equals(StdDraw.BLUE))
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                else
                    StdDraw.setPenColor(StdDraw.BLUE);
            }
            if (lastRowStart.equals(StdDraw.BLUE))
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else
                StdDraw.setPenColor(StdDraw.BLUE);

        }
        StdDraw.show();
    }
}
