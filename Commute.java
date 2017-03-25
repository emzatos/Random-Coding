import java.io.*;
import java.util.*;


public class Commute {
    public static class Node implements Comparable<Node> {
        int id;
        List<Edge> neighbors;
        long cost;
        boolean visited;
        List<Node> path;

        public Node(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
            this.path = new ArrayList<>();
            this.cost = Long.MAX_VALUE;
            this.visited = false;
        }

        public int compareTo(Node other) {
            return Long.compare(this.cost, other.cost);
        }

        public String toString() {
            return id + "";
        }
    }

    public static class Edge {
        Node dest;
        long weight;

        public Edge(Node dest, long weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<Node> graph, Node source) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        source.cost = 0;
        source.visited = true;
        pq.add(source);

        while (!pq.isEmpty()) {
            Node current = pq.remove();

            for (Edge edge : current.neighbors) {
                Node nextNode = edge.dest;
                long newCost = current.cost + edge.weight;

                if (!nextNode.visited || newCost < nextNode.cost) {
                    nextNode.cost = newCost;
                    nextNode.visited = true;
                    nextNode.path.clear();
                    nextNode.path.addAll(current.path);
                    nextNode.path.add(current);
                    pq.add(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        final Scanner scan = new Scanner(System.in);


//        for (int caseNum = 0; caseNum < numCases; caseNum++) {
            // Read in input
            final int numVertices = scan.nextInt();
            final int numEdges = scan.nextInt();

            final List<Node> graph = new ArrayList<>(numVertices);
            for (int i = 0; i < numVertices; i++) {
                graph.add(new Node(i));
            }

            for (int i = 0; i < numEdges; i++) {
                // Convert to 0 indexing
                final int start = scan.nextInt() - 1;
                final int end = scan.nextInt() - 1;
                final int weight = scan.nextInt();


                final Node nodeStart = graph.get(start);
                final Node nodeEnd = graph.get(end);

                nodeStart.neighbors.add(new Edge(nodeEnd, weight));
            }


            // All of the costs will be saved in the node objects
            dijkstra(graph, graph.get(0));

            long ans = graph.get(numVertices-1).cost;
            if (graph.get(numVertices-1).path.size() == 0) {
                for(int i=0; i<numVertices; i++)
                    System.out.println(graph.get(i).path);
                System.out.println(-1);

            } else {
                //System.out.println(Math.round(ans));

                ArrayList<Integer> nodes = new ArrayList<Integer>();

                graph.get(numVertices-1).path.forEach(n -> nodes.add(n.id+1));
                nodes.add(numVertices);

for(int i=0; i<numVertices; i++)
                    System.out.println(graph.get(i).path);

                for(int i=0; i<nodes.size(); i++){
                    if(i == nodes.size()-1){
                        System.out.println(nodes.get(i));
                        break;
                    }
                    System.out.print(nodes.get(i) + " ");

                }
            }
        
    }
}
