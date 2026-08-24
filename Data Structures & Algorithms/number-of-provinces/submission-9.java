class Solution {
    public int findCircleNum(int[][] isConnected) {
        // BFS based solution
        Set<Integer> visited = new HashSet<Integer>();
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                bfs(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }

    void bfs(int[][] isConnected, int city, Set<Integer> visited) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(city);
        visited.add(city);

        while (!queue.isEmpty()) {
            Integer currCity = queue.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[currCity][i] == 1 && !visited.contains(i)) {
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
    }
}