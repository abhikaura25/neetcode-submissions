class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        List<Integer> islandsFormed = new ArrayList<>();
        
        // Step-1 : Form the grid;
        int[][] grid = new int[m][n];
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                grid[i][j] = 0;
            }
        }
        int rows = grid.length;
        int cols = grid[0].length;

        // Step-1 : Convert them to Land

        for (int[] position : positions) {

            int rowPosition = position[0];
            int colPosition = position[1];
            grid[rowPosition][colPosition]=1;
            int numberOfIslands = 0;
            Set<Integer> visited = new HashSet<Integer>();

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c< cols; c++) {
                    if (!visited.contains(r*cols+c) && grid[r][c] == 1) {
                        doBfs(grid, r, c, rows, cols, visited);
                        numberOfIslands++;
                    }

                }
            }

            islandsFormed.add(numberOfIslands);
        }

        return islandsFormed;
    }

    void doBfs(int[][] grid, int row, int col, int rows, int cols, Set<Integer> visited) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{row,col});
        visited.add(row*cols+col);

        int[][] dirs = {
            {-1,0},
            {0,1},
            {0,-1},
            {1,0}
        };

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >=0 && nc >= 0 && nr < rows && nc < cols
                        && !visited.contains(nr*cols+nc)
                            && grid[nr][nc] == 1) {
                                queue.offer(new int[]{nr,nc});
                                visited.add(nr*cols+nc);
                }
            }
        }
    }
}
