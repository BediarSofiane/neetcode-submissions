class Solution {
      public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] globallyVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> neighbors = graph.get(prerequisites[i][0]);
            neighbors.add(prerequisites[i][1]);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (globallyVisited[prerequisites[i][0]]) {
                continue;
            }
            if (!dfs(prerequisites[i][0], graph, visited, globallyVisited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] globallyVisited) {
        globallyVisited[course] = true;
        List<Integer> neighbors = graph.get(course);
        visited[course] = true;
        for (int neighbor : neighbors) {
            if (visited[neighbor] || !dfs(neighbor, graph, visited, globallyVisited)) {
                return false;
            }
        }
        visited[course] = false;
        return true;
    }
}