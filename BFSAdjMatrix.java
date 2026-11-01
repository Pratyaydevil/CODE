import java.util.*;

public class BFSAdjMatrix {
    private int V;               // number of vertices
    private int[][] adjMatrix;   // adjacency matrix

    // Constructor
    public BFSAdjMatrix(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    // Add edge u -> v
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1; // 1 means edge exists
        // For undirected graph, also add adjMatrix[v][u] = 1;
    }

    // BFS traversal from source
    public void BFS(int src) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

            // Check all neighbors of u
            for (int v = 0; v < V; v++) {
                if (adjMatrix[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    // Example usage
    public static void main(String[] args) {
        BFSAdjMatrix graph = new BFSAdjMatrix(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Breadth First Traversal starting from vertex 2:");
        graph.BFS(2);
    }
}
