package src.main.java.array;

//Also a graph problem
public class IslandCount {
    public static void main(String[] args) {
        //input
        char[] row1 = {'1', '1', '1', '0', '1'};
        char[] row2 = {'1', '1', '0', '0', '0'};
        char[] row3 = {'1', '1', '0', '0', '0'};
        char[] row4 = {'0', '0', '0', '1', '1'};

        //output  = 3
        char[][] inputMatrix = {row1, row2, row3, row4};
        System.out.println(islandCount(inputMatrix));
    }

    public static int islandCount(char[][] grid) {
        int islandCount = 0;
        if (grid.length == 0) {
            return 0;
        }

        //i - rows , j - cols
        // O(n^2)
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                //if you encounter a 1, add count
                if (grid[i][j] == '1') {
                    islandCount += 1;
                    dfsNode(grid,i, j);
                }
            }
        }

        return islandCount;
    }


    //not sure if this is BFS or DFS = its DFS done recursively
    public static void dfsNode(char[][] grid, int i , int j){
        //check boundaries
        if(i<0 || j<0 || i>= grid.length || j>=grid[i].length || grid[i][j]=='0')
            return;

        //replace each adjacent occurrence of 1 with 0 - mark as visited
        grid[i][j] = '0';
        System.out.println(i + " "+ j);

        //traverse through all adjacent 1s recursively
        dfsNode(grid, i-1 , j); // top
        dfsNode(grid, i+1 , j); // bottom
        dfsNode(grid, i , j-1); // left
        dfsNode(grid, i , j+1); // right
    }

}
