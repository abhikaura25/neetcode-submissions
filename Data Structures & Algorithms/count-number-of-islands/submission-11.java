class Solution {
    public int numIslands(char[][] grid) {
        // BFS based solution

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        Set<Integer> visited = new HashSet<Integer>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r * cols + c)) {
                    bfs(grid, r, c, rows, cols, visited);
                    count++;
                }
            }
        }

        return count;
    }

    void bfs(char[][] grid, int row, int col, int rows, int cols, Set<Integer> visited) {
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] {row, col});
        visited.add(row * cols + col);

        int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == '1'
                    && !visited.contains(nr * cols + nc)) {
                    queue.offer(new int[] {nr, nc});
                    visited.add(nr * cols + nc);
                }
            }
        }
    }
}
