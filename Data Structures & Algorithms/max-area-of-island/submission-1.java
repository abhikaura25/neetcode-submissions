class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Set<Integer> visited = new HashSet<Integer>();
        List<Integer> islandAreaList = new ArrayList<Integer>();
        int maxArea = 0;
        for (int r=0; r<rows;r++) {
            for (int c=0;c<cols;c++) {
                if (!visited.contains(r*cols+c) && grid[r][c] == 1) {
                    int id = r*cols+c;
                    int area = doBfs(grid, r, c, rows, cols,visited);
                    if (area>maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
    }

    int doBfs(int[][] grid, int currRow, int currCol, int totalRows, int totalCols, Set<Integer> visited) {

        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{currRow, currCol});
        visited.add(currRow*totalCols+currCol);

        int[]dr = {-1,0,1,0,-1};
        int area = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            
            for (int d=0; d<4;d++) {
                int nr = r + dr[d];
                int nc = c + dr[d+1];

                if (nr>=0 && nc >=0 && nr<totalRows && nc < totalCols
                        && grid[nr][nc] == 1
                            && !visited.contains(nr*totalCols + nc)) {
                                area++;
                                queue.offer(new int[]{nr,nc});
                                visited.add(nr*totalCols + nc);

                        }

            }
        }

        return area;
    }
}
