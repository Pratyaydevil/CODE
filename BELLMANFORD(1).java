import java.util.*;

public class BellmanFordMatrix {
    private int V; // number of vertices
    private int[][] adjMatrix; // adjacency matrix

    // Constructor
    public BellmanFordMatrix(int V) {
        this.V = V;
        adjMatrix = new int[V][V];
        // Initialize with "infinity" for no edge
        for (int i = 0; i < V; i++) {
            Arrays.fill(adjMatrix[i], Integer.MAX_VALUE);
            adjMatrix[i][i] = 0; // distance to itself = 0
        }
    }

    // Add edge u -> v with weight w
    public void addEdge(int u, int v, int w) {
        adjMatrix[u][v] = w;
    }

    // Bellman-Ford algorithm
    public void bellmanFord(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax edges V-1 times
        for (int i = 1; i < V; i++) {
            for (int u = 0; u < V; u++) {
                for (int v = 0; v < V; v++) {
                    if (adjMatrix[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE
                            && dist[u] + adjMatrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + adjMatrix[u][v];
                    }
                }
            }
        }

        // Check for negative weight cycles
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (adjMatrix[u][v] != Integer.MAX_VALUE && dist[u] != Integer.MAX_VALUE
                        && dist[u] + adjMatrix[u][v] < dist[v]) {
                    System.out.println("Graph contains a negative weight cycle!");
                    return;
                }
            }
        }

        // Print shortest distances
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + (dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]));
        }
    }

    // Example usage
    public static void main(String[] args) {
        int V = 5;
        BellmanFordMatrix graph = new BellmanFordMatrix(V);

        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        graph.bellmanFord(0);
    }
}

