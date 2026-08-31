class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Create Adjacency List & compute graph indegree
        Map <Integer, List<Integer>> adjList = new HashMap <Integer, List<Integer>>();

        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int src = prerequisite[1];
            int dest = prerequisite[0];

            adjList.computeIfAbsent(src, k -> new ArrayList<Integer>()).add(dest);

            indegree[dest]++;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();

        // Add all the courses to graph where indegree is zero
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            result.add(node);

            List<Integer> neighbours = adjList.getOrDefault(node, Collections.emptyList());

            for (Integer neighbour : neighbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (result.size() < numCourses) {
            return false;
        }

        return true;
    }
}
