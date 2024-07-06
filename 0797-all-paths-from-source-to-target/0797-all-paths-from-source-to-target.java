class Solution {
    public void findPaths(int src, int target, int[][]graph, List<Integer> cPath, 
                         List<List<Integer>> allPaths) {
        if (src == target) {
            allPaths.add(new ArrayList<>(cPath));
            return;
        }
        for (int i = 0; i < graph[src].length; i++) {
            cPath.add(graph[src][i]);
            findPaths(graph[src][i], target, graph, cPath, allPaths);
            cPath.remove(cPath.size() - 1);
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        findPaths(0, graph.length - 1, graph, currPath, allPaths);
        return allPaths;
    }
}