public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] grid = new int[m][n];

        // place mines
        for (int i = 0; i < k; i++) {

            int pickM = (int) (Math.random() * m);
            int pickN = (int) (Math.random() * n);
            while (grid[pickM][pickN] != 0) {
                pickM = (int) (Math.random() * m);
                pickN = (int) (Math.random() * n);
            }
            // SAgrid[pickN][pickM] == 0
            grid[pickM][pickN] = -1;
        }

        // go through map updating mines
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    // found a mine
                    if ((i > 0) && (j > 0) && (grid[i - 1][j - 1] != -1)) grid[i - 1][j - 1]++;
                    if ((i > 0) && (grid[i - 1][j] != -1)) grid[i - 1][j]++;
                    if ((i > 0) && (j < n - 1) && (grid[i - 1][j + 1] != -1)) grid[i - 1][j + 1]++;
                    if ((j > 0) && (grid[i][j - 1] != -1)) grid[i][j - 1]++;

                    if ((j < n - 1) && (grid[i][j + 1] != -1)) grid[i][j + 1]++;
                    if ((i < m - 1) && (j > 0) && (grid[i + 1][j - 1] != -1)) grid[i + 1][j - 1]++;
                    if ((i < m - 1) && (grid[i + 1][j] != -1)) grid[i + 1][j]++;
                    if ((i < m - 1) && (j < n - 1) && (grid[i + 1][j + 1] != -1))
                        grid[i + 1][j + 1]++;

                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1)
                    System.out.print("*");
                else
                    System.out.print(grid[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }
}
