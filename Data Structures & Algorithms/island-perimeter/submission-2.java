class Solution {
    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Set<Integer> visited = new HashSet<>();
        int perimeter = 0;
        
        for (int r=0; r<rows;r++) {
            for (int c=0; c<cols;c++) {
                if (!visited.contains(r*cols+c) && grid[r][c] == 1) {
                    perimeter += doBfs(grid, r, c, rows, cols, visited);
                }
            }
        }

        return perimeter;   
    }

    public int doBfs(int[][] grid, int currRow, int currCol, int totalRows, int totalCols, Set<Integer> visited) {

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{currRow, currCol});
        visited.add(currRow*totalCols + currCol);

        int[] dr = {-1,0,1,0,-1};
        int perimeter = 0;

        while (!queue.isEmpty()) {
            int[] currCell = queue.poll();
            int r = currCell[0];
            int c = currCell[1];
            for (int d=0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dr[d+1];

                if (nr < 0 || nc < 0 || nr >= totalRows || nc >= totalCols) {
                    perimeter++;
                } else if (grid[nr][nc]==0) {
                    perimeter++;
                } else if (!visited.contains(nr*totalCols+nc)) {
                    queue.offer(new int[]{nr,nc});
                    visited.add(nr*totalCols+nc);
                }
            }
        }

        return perimeter;
    }
}