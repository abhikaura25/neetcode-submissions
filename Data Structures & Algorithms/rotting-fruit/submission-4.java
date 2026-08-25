class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int freshOrangesCount = 0;
        int time = 0;

        Queue<int[]> queue = new ArrayDeque<int[]>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshOrangesCount++;
                }

                if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        while (!queue.isEmpty() && freshOrangesCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                        queue.offer(new int[] {nr, nc});
                        grid[nr][nc] = 2;
                        freshOrangesCount--;
                    }
                }
            }
            time++;
        }

        return freshOrangesCount == 0 ? time : -1;
    }
}
