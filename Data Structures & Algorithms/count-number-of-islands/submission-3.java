class Solution {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        Set<Integer> visited = new HashSet();
        int numOfIslands = 0;

        for (int r=0 ; r< rows; r++) {
            for (int c=0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited.contains(r*cols+c)) {
                    doBfs(grid, r, c, rows, cols, visited);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

    void doBfs(
        char[][] grid, 
        int currRow, 
        int currCol, 
        int totalRows, 
        int totalCols, 
        Set<Integer> visited) {

            Queue<int[]> queue = new ArrayDeque();
            queue.offer(new int[]{currRow, currCol});
            visited.add(currRow*totalCols + currCol);

            int[] dr = {-1,0,1,0,-1};

            while (!queue.isEmpty()) {
                int[] currCell = queue.poll();
                int r = currCell[0];
                int c = currCell[1];

                for (int d=0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dr[d+1];

                    if (nr >=0 && nc >=0 && nr < totalRows && nc < totalCols && grid[nr][nc] == '1') {
                        if (!visited.contains(nr*totalCols + nc)) {
                            queue.offer(new int[]{nr,nc});
                            visited.add(nr*totalCols + nc);
                        }
                    }
                }
            }
        }
}
