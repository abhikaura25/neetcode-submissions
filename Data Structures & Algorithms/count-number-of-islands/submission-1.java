class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;

        Set<Integer> visited = new HashSet<>();

        for (int i=0 ; i< rows; i++) {
            for (int j=0; j< cols; j++) {
                int id = i * cols + j;
                if (grid[i][j] == '1' && !visited.contains(id)) {
                    doBfs(grid, i, j, rows, cols, visited);
                    numberOfIslands++;

                }
            }
        }

        return numberOfIslands;     
    }

    public void doBfs(char[][] grid, 
                       int row, 
                       int col, 
                       int totalRows, 
                       int totalCols, 
                       Set<Integer> visited) {
    
    Queue <int[]> queue = new ArrayDeque<>();
    int id = row * totalCols + col;
    queue.offer(new int[]{row,col});
    visited.add(id);

    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int r = curr[0];
        int c = curr[1];

        for (int d=0; d<4;d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >=0 && nr < totalRows && nc < totalCols) {
                int newId = nr * totalCols + nc;
                if (grid[nr][nc] == '1' && !visited.contains(newId)) {
                    queue.offer(new int[]{nr,nc});
                    visited.add(newId);
                }
            }
        }
    }
    }
}
