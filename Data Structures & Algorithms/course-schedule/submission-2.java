class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (prerequisites.length == 0) {
            return true;
        }

        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>> ();
        Queue<Integer> queue = new ArrayDeque<Integer>();


        for (int[] prerequisite: prerequisites) {
            int src = prerequisite[1];
            int dest = prerequisite[0];

            adjList.computeIfAbsent(src, k-> new ArrayList<Integer>()).add(dest);
            indegree[dest]++;
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
            queue.offer(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            List<Integer> neighbours = adjList.getOrDefault(node, Collections.emptyList());
            for (Integer neighbour: neighbours) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        return (count== numCourses) ? true: false; 
    }
}
