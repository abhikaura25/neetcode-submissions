class Solution {
    public int numIslands(char[][] grid) {

        Set<Integer> visited = new HashSet<>();
        int islands = 0;

        int rows = grid.length;
        int columns = grid[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int id = r * columns + c;
                if (grid[r][c] == '1' && !visited.contains(id)) {
                    doBfs(grid, visited, r, c, rows, columns);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void doBfs(char[][] grid, Set<Integer> visited, int sr, int sc, int rows, int cols) {

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{sr, sc});

        int id = sr * cols + sc;
        visited.add (id);

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            for (int d = 0; d < 4 ; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                int newId = nr * cols + nc;

                if (nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc] == '1') {
                    if (!visited.contains(newId)) {
                        visited.add(newId);
                        queue.add(new int[]{nr,nc});
                    }    
                }
            }
        }
    }
}
