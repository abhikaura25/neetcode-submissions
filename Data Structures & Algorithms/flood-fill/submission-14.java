class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        doDfs(image, sr, sc, color, originalColor);

        return image;   
    }

    public void doDfs(int[][] image, int r, int c, int color, int originalColor) {

        int rows = image.length;
        int cols = image[0].length;

        // check out of Bounds
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        if (image[r][c] != originalColor) {
            return;
        }

        image[r][c] = color;

        doDfs(image, r+1, c, color, originalColor);
        doDfs(image, r, c+1, color, originalColor);
        doDfs(image, r-1, c, color, originalColor);
        doDfs(image, r, c-1, color, originalColor);
    }
}