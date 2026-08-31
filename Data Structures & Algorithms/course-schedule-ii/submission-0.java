class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

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
        int completed = 0;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            completed++;
            result.add(node);

            List<Integer> neighbours = adjList.getOrDefault(node, Collections.emptyList());

            for (Integer neighbour : neighbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (completed != numCourses) {
            return new int[]{};
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
