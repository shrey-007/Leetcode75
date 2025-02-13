package HashMap;

public class EqualRowAndColumnPairs {
    // let's do it using brute force, go to every cell check whether row and col are equal or not
    // brute force solution works
    // but solve using hashmap
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isEqual(i,j,n,grid)) count++;
            }
        }

        return count;
    }

    public boolean isEqual(int row,int col,int n,int [][]grid){
        for (int i = 0; i <n; i++) {
            if(grid[i][col]!=grid[row][i]) return false;
        }
        return true;
    }

}
