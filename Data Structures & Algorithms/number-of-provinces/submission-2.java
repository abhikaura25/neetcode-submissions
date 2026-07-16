class Solution {
    public int findCircleNum(int[][] isConnected) {

        int provinanceCount = 0;
        Set<Integer> visited = new HashSet();
        for (int i = 0; i<isConnected.length; i++) {
            if (!visited.contains(i)) {
                doBfs(isConnected, i , visited);
                provinanceCount++;
            }
        }
        return provinanceCount;     
    }

    /**
    @param isConnected: input grid.
    @param start: staring node in graph.
    @param visited: visited city set.

    This function do breadth first search.
    **/
    void doBfs(int[][] isConnected, int start, Set<Integer> visited) {
        
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Integer city = queue.poll();
            for (int j= 0; j<isConnected.length;j++) {
                if(isConnected[city][j] == 1 && !visited.contains(j)) {
                    queue.offer(j);
                    visited.add(j);
                }
            }
        }
    }
}