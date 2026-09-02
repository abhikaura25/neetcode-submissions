class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();

        // Create graph and indegree.
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<Character>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }

            int length = Math.min(first.length(), second.length());

            for (int j = 0; j < length; j++) {
                char a = first.charAt(j);
                char b = second.charAt(j);

                if (a != b) {
                    if (graph.get(a).add(b)) {
                        indegree.put(b, indegree.get(b) + 1);
                    }
                    break;
                }
                
            }
        }

        Queue<Character> queue = new ArrayDeque<Character>();

        //Topological sort
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            Character curr = queue.poll();
            result.append(curr);
            Set<Character> neighbours = graph.getOrDefault(curr, Collections.emptySet());
            for (Character neighbour : neighbours) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (result.length() != indegree.size()) {
            return "";
        }

        return result.toString();
    }
}
