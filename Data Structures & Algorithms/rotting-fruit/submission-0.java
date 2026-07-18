class Solution {
    public int orangesRotting(int[][] grid) {

        if (grid==null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int freshFruitCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int r=0; r < rows; r++) {
            for (int c=0; c <cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r,c});
                }
                if (grid[r][c] == 1) {
                    freshFruitCount++;
                }
            }
        }

        int[] dr = {-1,0,1,0,-1};
        int minutes = 0;
        while(!queue.isEmpty() && freshFruitCount>0) {
            int size = queue.size();
            for (int s=0; s<size;s++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int d=0; d<4;d++) {
                    int nr = r + dr[d];
                    int nc = c + dr[d+1];

                    if (nr>=0 && nc>=0 && nr<rows && nc<cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshFruitCount--;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }

        return freshFruitCount == 0 ? minutes : -1;
    }
}
