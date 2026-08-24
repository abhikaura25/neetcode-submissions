class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // BFS solution

        // Get Rows and Cols
        int rows = image.length;
        int cols = image[0].length;

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        Queue<int[]> queue = new ArrayDeque<int[]>();
        
        image[sr][sc] = color;
        queue.offer(new int[] {sr, sc});

        int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols
                    && image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }

        return image;
    }
}