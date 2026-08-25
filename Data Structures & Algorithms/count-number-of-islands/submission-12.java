class Solution {
    public int numIslands(char[][] grid) {
        // DFS based solution

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        Set<Integer> visited = new HashSet<Integer>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r * cols + c)) {
                    dfs(grid, r, c, rows, cols, visited);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(char[][] grid, int row, int col, int rows, int cols, Set<Integer> visited) {
        // check out of bounds
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return;
        }

        if (grid[row][col] == '0' || visited.contains(row * cols + col)) {
            return;
        }

        visited.add(row * cols + col);

        dfs(grid, row+1, col, rows, cols, visited);
        dfs(grid, row-1, col, rows, cols, visited);
        dfs(grid, row, col+1, rows, cols, visited);
        dfs(grid, row, col-1, rows, cols, visited);
    }
}
