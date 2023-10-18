import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class implementation_Of_Graph {

    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    static class WeightedEdge{
        int src;
        int dest;
        int weight;

        public WeightedEdge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<Edge>();
        }

        //for first example:
//        graph[0].add(new Edge(0,2));
//
//        graph[1].add(new Edge(1,2));
//        graph[1].add(new Edge(1,3));
//
//        graph[2].add(new Edge(2,0));
//        graph[2].add(new Edge(2,1));
//        graph[2].add(new Edge(2,3));
//
//        graph[3].add(new Edge(3,1));
//        graph[3].add(new Edge(3,2));

        //the below is the construction of graph for bfs traversal
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }

    public static void createWeightedGraph(ArrayList<WeightedEdge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<WeightedEdge>();
        }

        graph[0].add(new WeightedEdge(0,2,2));

        graph[1].add(new WeightedEdge(1,2,10));
        graph[1].add(new WeightedEdge(1,3,0));

        graph[2].add(new WeightedEdge(2,0,2));
        graph[2].add(new WeightedEdge(2,1,10));
        graph[2].add(new WeightedEdge(2,3,-1));

        graph[3].add(new WeightedEdge(3,1,0));
        graph[3].add(new WeightedEdge(3,2,-1));
    }
    //below function is for bfs traversal:
    public static void bfs(ArrayList<Edge> graph[], int v){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[v];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(visit[curr] == false){
                System.out.print(curr+" ");
                visit[curr] = true;  //make visit egde as true
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //below function is for bfs traversal for different component(2 graphs in single graph) graph:
    public static void bfs1(ArrayList<Edge> graph[], int v,boolean[] visit,int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(visit[curr] == false){
                System.out.print(curr+" ");
                visit[curr] = true;  //make visit egde as true
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] visit){
        System.out.println(curr+" ");
        visit[curr] = true;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(visit[e.dest] == false) {
                dfs(graph, e.dest, visit);
            }
        }
    }
    public static void main(String[] args) {

        //for unweighted graph:
//        int vertex = 4;
//        ArrayList<Edge>[] graph= new ArrayList[4];
//        createGraph(graph);
//
//        //for printing neighbours of 2:
//        for(int i=0; i<graph[2].size(); i++){
//            Edge e = graph[2].get(i);
//            System.out.print(e.dest+" ");
//
//        }

        //for weighted graph:
//        int vertex = 4;
//        ArrayList<WeightedEdge>[] graph= new ArrayList[4];
//        createWeightedGraph(graph);
//
//        //for printing neighbours of 2:
//        for(int i=0; i<graph[2].size(); i++){
//            WeightedEdge e = graph[2].get(i);
//            System.out.println("edge neighbour -> "+e.dest+", edge Weight -> "+e.weight);
//        }

        //for bfs traversal:
//        int v = 7;
        /*
                1 --- 3
               /      | \
              0       |  5 --- 6
               \      | /
                2 --- 4
         */

//        ArrayList<Edge> graph[] = new ArrayList[v];
//        createGraph(graph);
//        bfs(graph,v);


        //if a graph is given in different components manner than these will be some changes:
//        int v = 7;
//        ArrayList<Edge> graph[] = new ArrayList[v];
//        boolean[] visit = new boolean[v];
//        createGraph(graph);
//        for(int i=0; i<v; i++){
//            if(visit[i] == false){
//                bfs1(graph,v,visit,i);
//            }
//        }

        //below code is for dfs traversal:
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        boolean[] visit = new boolean[v];
        createGraph(graph);
        dfs(graph,0,visit);




    }
}
