class Solution {
    public int findCircleNum(int[][] isConnected) {

        Set<Integer> visited = new HashSet<>();
        int provinanceCount = 0;

        for (int i=0; i<isConnected.length; i++) {
            if (!visited.contains(i)) {
                 doBfs(isConnected, i, visited);
                 provinanceCount++;
            }
        }

        return provinanceCount;
    }

    void doBfs(int[][] isConnected, int start, Set<Integer> visited) {
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int j=0; j<isConnected.length; j++) {
                if (!visited.contains(j) && isConnected[city][j] == 1) {
                    queue.offer(j);
                    visited.add(j);
                }
            }
        }

    }
}