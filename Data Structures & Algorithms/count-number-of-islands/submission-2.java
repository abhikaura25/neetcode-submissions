class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int numberOfIslands = 0;
        Set<Integer> visited = new HashSet();

        for (int r=0; r < grid.length; r++) {
            for (int c=0; c < grid[0].length; c++) {
                int id = r * cols + c;
                if (!visited.contains(id) && grid[r][c] == '1') {
                    doBfs(grid, r, c, rows, cols, visited);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;

    }

    void doBfs(char[][] grid , int row, int col, int totalRows, int totalCols, Set<Integer> visited) {

        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{row, col});
        visited.add(row*totalCols + col);

        int [] dr = {-1, 0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int r = currCell[0];
            int c = currCell[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dr[d+1];
                if (nr>=0 && nc >=0 && nr < totalRows && nc < totalCols) {
                    int newId = nr * totalCols + nc;
                    if (!visited.contains(newId) && grid[nr][nc] == '1') {
                        queue.offer(new int[]{nr,nc});
                        visited.add(newId);
                    }
                }
            }
        }
    }
}
