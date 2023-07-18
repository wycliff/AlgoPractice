package src.main.java.graph;

public class MaxAreaOfLand {
    public static int maxAreaOfIsland(int[][] grid) {
        // rc [][]
        // Loop through entire grid
        // Occurrence of 1 :
        // do dfs , count,
        // mark visited 1 -> 0
        //store max (compare with prev max)

        if (grid.length == 0) {
            return 0;
        }

        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1) {
                    int count = doDFS(grid, i, j);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        return maxCount;
    }

    public static int doDFS(int[][] grid, int i, int j) {
        int count = 0;
        //check boundaries
        if (
                i < 0 ||
                        i >= grid.length ||
                        j < 0 ||
                        j >= grid[i].length ||
                        grid[i][j] == 0
        ) {
            return 0;
        } else {

            // mark visited
            grid[i][j] = 0;
            count++;

            //dfs around current element
            count += doDFS(grid, i - 1, j) + doDFS(grid, i + 1, j) + doDFS(grid, i, j - 1) + doDFS(grid, i, j + 1);
            return count;
        }
    }


    public static void main(String[] args) {
        int[] row1 = {1, 1, 1, 0, 1};
        int[] row2 = {1, 1, 0, 0, 0};
        int[] row3 = {1, 1, 0, 0, 0};
        int[] row4 = {0, 0, 0, 1, 1};

        //output  = 3
        int[][] inputMatrix = {row1, row2, row3, row4};
        System.out.println(maxAreaOfIsland(inputMatrix));
    }
}


