class Solution {
    public int findCircleNum(int[][] isConnected) {
        // dfs based solution

        int count = 0;
        Set<Integer> visited = new HashSet<Integer>();

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                dfs(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }

    void dfs(int[][] isConnected, int city, Set<Integer> visited) {
        visited.add(city);
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited.contains(i)) {
                visited.add(i);
                dfs(isConnected, i, visited);
            }
        }
    }
}