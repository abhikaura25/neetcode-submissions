class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new ArrayDeque<int[]>();
        Set<Integer> visited = new HashSet();

        queue.offer(new int[] {0, 0});
        visited.add(0 * cols + 0);

        int length = 1;

        int[][] dirs = {{-1, 1}, {-1, 0}, {-1, -1}, {0, 1}, {0, -1}, {1, 1}, {1, 0}, {1, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                if (r == rows - 1 && c == cols - 1) return length;

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nc >= 0 && nr < rows && nc < cols
                        && !visited.contains(nr * cols + nc) && grid[nr][nc] == 0) {
                        queue.offer(new int[] {nr, nc});
                        visited.add(nr * cols + nc);
                    }
                }
            }
            length++;
        }
        return -1;
    }
}