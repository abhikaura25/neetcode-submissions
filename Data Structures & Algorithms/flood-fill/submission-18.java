class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //DFS Solution

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }
        
        dfs(image, sr, sc, color, originalColor);

        return image;
        
    }

    public void dfs(int[][] image, int row, int col, int color, int originalColor) {

        int rows = image.length;
        int cols = image[0].length;

        // check for overflow conditions
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return;
        }

        // check if color is valid
        if (image[row][col] != originalColor) {
            return;
        }

        image[row][col] = color;

        dfs(image, row+1, col, color, originalColor);
        dfs(image, row-1, col, color, originalColor);
        dfs(image, row, col+1, color, originalColor);
        dfs(image, row, col-1, color, originalColor);
    }
}