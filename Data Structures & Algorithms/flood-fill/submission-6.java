class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int rows = image.length;
        int cols = image[0].length;

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        } else {
            image[sr][sc] = color;
        }

        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{sr,sc});

        int[] dr = { -1, 0, 1, 0, -1};

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int d= 0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dr[d+1];

                if (nr>=0 && nc >= 0 && nr < rows && nc < cols && image[nr][nc] == originalColor) {
                    image[nr][nc] = color;
                    queue.add(new int[]{nr, nc});
                }
            }

        }

        return image;   
    }
}