import java.util.*;

import java.util.*;

class GraphDFSIterative {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    void addEdge(int src, int dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // undirected
    }

    void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");

                for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphDFSIterative g = new GraphDFSIterative();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        System.out.println("DFS starting from node 0:");
        g.dfs(0);
    }
}

