class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int columns = image[0].length;

        int originalColor = image[sr][sc]; 

        if (originalColor == color) {
            return image;
        } else {
            image[sr][sc] = color;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr,sc});
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell [1];

            for (int i =0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >=0 && nr < rows && nc < columns
                    && image[nr][nc] == originalColor) {
                        image[nr][nc] = color;
                        queue.offer(new int[] {nr,nc});
                    }
            }
        }

        return image;

        
    }
}