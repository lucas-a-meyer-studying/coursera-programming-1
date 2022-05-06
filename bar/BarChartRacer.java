import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();

        String filename = args[0];
        int bars = Integer.parseInt(args[1]);

        In f = new In(filename);

        String title = f.readLine();
        String axis = f.readLine();
        String source = f.readLine();
        BarChart chart = new BarChart(title, axis, source);
        String date = "";

        f.readLine();


        while (f.hasNextLine()) {
            String strGroupSize = f.readLine();
            int groupSize = Integer.parseInt(strGroupSize);
            Bar[] bList = new Bar[groupSize];

            for (int i = 0; i < groupSize; i++) {
                String line = f.readLine();
                String[] parts = line.split(",");
                date = parts[0];
                String name = parts[1];
                int value = Integer.parseInt(parts[3]);
                String category = parts[4];

                bList[i] = new Bar(name, value, category);
            }

            Arrays.sort(bList);
            for (int i = 0; i < bars; i++)
                chart.add(bList[groupSize - i - 1].getName(), bList[groupSize - i - 1].getValue(),
                          bList[groupSize - i - 1].getCategory());

            chart.setCaption(date);

            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            StdDraw.clear();
            f.readLine();
            chart.reset();
        }

    }
}
