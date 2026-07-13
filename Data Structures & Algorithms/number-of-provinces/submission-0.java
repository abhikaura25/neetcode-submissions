class Solution {
    public int findCircleNum(int[][] isConnected) {

        Set<Integer> visited = new HashSet<>();
        int provinanceCount = 0;
        for (int i = 0; i < isConnected.length ; i++) {
            if (!visited.contains(i)) {
                doBfs(isConnected, visited, i);
                provinanceCount ++;
            }
        }

        return provinanceCount;
        
    }

    public void doBfs(int[][] graph, Set<Integer> visited, int start) {

        Queue<Integer> queue = new ArrayDeque<> ();

        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int city = queue.poll();

            for (int j=0 ; j < graph.length ; j++) {
                if (graph[city][j] == 1 && !visited.contains(j)) {
                    queue.offer(j);
                    visited.add(j);
                }
            }
        }
    }
}