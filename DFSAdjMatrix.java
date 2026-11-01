import java.util.*;

public class DFSAdjMatrix {
    private int V;               // number of vertices
    private int[][] adjMatrix;   // adjacency matrix

    // Constructor
    public DFSAdjMatrix(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
    }

    // Add edge u -> v
    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1; // 1 means edge exists
        // For undirected graph, also add adjMatrix[v][u] = 1;
    }

    // DFS utility function
    private void DFSUtil(int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");

        // Explore all neighbors of u
        for (int v = 0; v < V; v++) {
            if (adjMatrix[u][v] == 1 && !visited[v]) {
                DFSUtil(v, visited);
            }
        }
    }

    // DFS traversal from source
    public void DFS(int src) {
        boolean[] visited = new boolean[V];
        DFSUtil(src, visited);
    }

    // Example usage
    public static void main(String[] args) {
        DFSAdjMatrix graph = new DFSAdjMatrix(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Depth First Traversal starting from vertex 2:");
        graph.DFS(2);
    }
}
