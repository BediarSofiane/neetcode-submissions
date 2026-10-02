class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> neighbors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            neighbors.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            neighbors.get(edge[0]).add(edge[1]);
            neighbors.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, -1, neighbors, visited);
            }
        }
        return components;
    }

    private void dfs(int node, int parent, List<List<Integer>> neighbors, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : neighbors.get(node)) {
            if (neighbor == parent || visited[neighbor]) {
                continue;
            }
            dfs(neighbor, node, neighbors, visited);
        }
    }
}
