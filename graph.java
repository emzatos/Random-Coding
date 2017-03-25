import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Problem{

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
				return false

			n.children.add(this);
			this.children.add(n);
			return true;
		}

		public int index(Node n){
			return this.children.indexOf(n);
		}

		public void resetVisited(){
			this.visited = false;
			for(int i=0; i<this.children; i++){
				this.children.get(i).visited = false;
				this.children.get(i).resetVisited();
			}


		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int cases = 0; cases < sc.nextInt(); cases++){
			int numNodes = sc.nextInt();
			int numEdges = sc.nextInt();
			int startNode = sc.nextInt();
			int maxDistance = sc.nextInt();

			for(int i=0; i<numEdges; i++)
		}
	}
}