
    import java.util.*;

public class Dijkstra {

    public static void dijkstra(int[][] graph, int source) {

        int n = graph.length;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // {distance, node}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        dist[source] = 0;
        pq.offer(new int[]{0, source});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int currentDist = current[0];
            int u = current[1];

            // Ignore old/outdated distance
            if (currentDist > dist[u]) {
                continue;
            }

            // Check all neighbours
            for (int v = 0; v < n; v++) {

                // Edge exists
                if (graph[u][v] != 0) {

                    int newDist = currentDist + graph[u][v];

                    // Relaxation
                    if (newDist < dist[v]) {

                        dist[v] = newDist;

                        pq.offer(new int[]{
                            newDist, v
                        });
                    }
                }
            }
        }

        // Print result
        for (int i = 0; i < n; i++) {
            System.out.println(
                "Distance from " + source +
                " to " + i + " = " + dist[i]
            );
        }
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 4, 1, 0, 0},
            {4, 0, 2, 1, 0},
            {1, 2, 0, 4, 0},
            {0, 1, 4, 0, 3},
            {0, 0, 0, 3, 0}
        };

        dijkstra(graph, 0);
    }
}

