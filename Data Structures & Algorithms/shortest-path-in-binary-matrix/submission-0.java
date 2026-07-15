class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1) {
            return -1;
        }

        int pathVisit = 1;
        int[][] dr = {{-1,-1}, {-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

        Set<Integer> visited = new HashSet();
        Queue<int[]> queue = new ArrayDeque();

        queue.offer(new int[]{0,0});
        visited.add(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s=0; s<size; s++) {
                int[] currCell = queue.poll();

                int r = currCell[0];
                int c = currCell[1];

                if (r == rows-1 && c ==cols-1) {
                    return pathVisit;
                }

                for (int[] d : dr) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >=0 && nc >=0 && nr < rows && nc < cols && grid[nr][nc] ==0) {
                        if (!visited.contains(nr*cols + nc)) {
                            visited.add(nr*cols + nc);
                            queue.offer(new int[]{nr,nc});
                        }
                    }

                }
            }
            pathVisit++;
        }
        return -1;
    }
}