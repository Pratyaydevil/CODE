import java.util.*;

class BFS{
 private Map<Integer,List<Integer>> adjList=new HashMap<>();

void addEdge(int u,int v){
    adjList.putIfAbsent(u,new ArrayList<>());
    adjList.putIfAbsent(v,new ArrayList<>());
    adjList.get(u).add(v);
    adjList.get(v).add(u);


}


void bfs(int start){

    Set<Integer>visited=new HashSet<>();
    Queue<Integer>queue=new LinkedList<>();
    visited.add(start);
    queue.add(start);


    while(!queue.isEmpty()){


        int node=queue.poll();
        System.out.print(node+" ");

        for(int neighboor:adjList.get(node)){

            if(!visited.contains(neighboor)){
                visited.add(neighboor);
                queue.add(neighboor);
            }
        }
    }
}

public static void main(String[] args) {
        BFS g = new BFS();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        System.out.println("BFS starting from node 0:");
        g.bfs(0);
    }
}
