import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Problem{

	public static class Graph{

		ArrayList<Node> nodes;
		public Graph(){
			nodes = new ArrayList<Node>();
		}

		public boolean add(Node n){
			if(this.nodes.contains(n)){

				return false;
			}
			return this.nodes.add(n);
		}

		public void reset(){
			for(Node n : nodes)
				n.visited = false;
		}

		public Node getByID(int n){
			for(int i=0; i<nodes.size(); i++){
				if(nodes.get(i).id == n)
					return nodes.get(i);
			}

			return null;
		}

	}

	public static class Node{
		int id;
		ArrayList<Node> children;
		boolean visited;
		public Node(int id){
			this.id = id;
			this.children = new ArrayList<Node>();
			this.visited = false;
		}

		public boolean connect(Node n){
			if(n.children.indexOf(this) != -1 || this.children.indexOf(n) != -1)
				return false;

			n.children.add(this);
			this.children.add(n);
			return true;
		}

		public int index(Node n){
			return this.children.indexOf(n);
		}

		public boolean equals(Object n){
			Node x = (Node)n;
			return this.id == x.id;
		}

		public String toString(){
			return "" + this.id;
		}



	}

	public static void setVisited(Node n){

		if(n.visited == true)
			return;
		n.visited = true;
		for(int i=0; i<n.children.size(); i++){
			setVisited(n.children.get(i));
		}
	}

	public static int countComponents(Graph g){
		ArrayList<Node> vals = g.nodes;
		int components = 0;
		while(!vals.isEmpty()){
			setVisited(vals.get(0));
			int i=0;
			while(i < vals.size()){

				if(vals.get(i).visited == true){

					vals.remove(vals.get(i));
					i=0;
					continue;
				}

				i++;
			}

			components++;

		}

		g.reset();
		return components;
	}

	public static int countNeighbors(Node n, int distance){
		if(distance <= 0)
			return 0;
		int count = 0;
		n.visited = true;
		for(int i=0; i<n.children.size(); i++){
			if(n.children.get(i).visited == false){
				count++;
				n.children.get(i).visited = true;
				count += countNeighbors(n.children.get(i), distance-1);
			}

		}

		return count;


	}


	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Graph g = new Graph();
		int t = sc.nextInt();
		for(int cases = 0; cases < t; cases++){
			int numNodes = sc.nextInt();
			int numEdges = sc.nextInt();
			int startNode = sc.nextInt();

			int maxDistance = sc.nextInt();

			

			for(int i=0; i<numEdges; i++){
				Node n = new Node(sc.nextInt());

				Node m = new Node(sc.nextInt());

				// n = g.add(n) ? n : g.nodes.get(g.nodes.indexOf(n));
				// m = g.add(m) ? m : g.nodes.get(g.nodes.indexOf(m));

				if(g.add(n)){
					numNodes--;

				}else{
					n = g.nodes.get(g.nodes.indexOf(n));
				}

				if(g.add(m)){
					numNodes--;

				}else{
					m = g.nodes.get(g.nodes.indexOf(m));
				}



				n.connect(m);


			//	System.out.println("connected " + n.id + " with " + m.id);
			}

			

			int neighbors = 1+countNeighbors(g.getByID(startNode), maxDistance);
			int components = numNodes + countComponents(g);


			System.out.println(components + " " + neighbors);


		}

	}
}