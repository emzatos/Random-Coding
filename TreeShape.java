/*

This is the solution to problem number three of this year's ICPC World Finals. Essentially, trees of a given size are given as nodes,
the purpose of the program is to determine the number of unique shapes of all the given trees. I did this by keeping a boolean list of 
the children of each tree, then comparing the lists to each other.

Emran Shafaq

*/

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;

public class TreeShape{
	
	public static class Node{
		int value = 0;
		Node leftChild = null;
		Node rightChild = null;

		public Node(int value){
			this.value = value;
			this.leftChild = null;
			this.rightChild = null;
		}
		public Node(int value, Node leftChild, Node rightChild){
			this.value = value;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}


	}

	public static class Tree{
		Node root = null;
		ArrayList<Boolean> shape;
		public Tree(){
			this.root = null;
			this.shape = new ArrayList<Boolean>();
		}
		public Tree(Node root){
			this.root = root;
			this.shape = new ArrayList<Boolean>();
		}

		public void add(Node n){
			Node current = this.root;
			if(this.root == null){
				this.root = n;
				return;
			}
			while(current != null){
				if(n.value < current.value){
					if(current.leftChild == null){
						current.leftChild = n;
						return;
					}else{
						current = current.leftChild;
						continue;
					}
				}else if(n.value > current.value){
					if(current.rightChild == null){
						current.rightChild = n;
						return;
					}else{
						current = current.rightChild;
						continue;
					}
				}else{
					return;
				}
			}
		}

		//method written for testing purposes, not used in main method
		public boolean inTree(int n){
			Node current = this.root;
			while(current != null){
				if(current.value == n) return true;
				if(n < current.value){
					current = current.leftChild;
					continue;
				}
				else if(n > current.value){
					current = current.rightChild;
					continue;
				}
			}

			return false;
		}

		public boolean sameShape(Tree t){
			for(int i=0; i<t.shape.size(); i++){
				if(t.shape.get(i) != this.shape.get(i)) return false;
			}

			return true;
		}

		public String postfix(Node current){
			if(current == null){
				return "";
			}
			if(current.leftChild != null){
				this.shape.add(true);
			}else{
				this.shape.add(false);
			}

			if(current.rightChild != null){
				this.shape.add(true);
			}else{
				this.shape.add(false);
			}


			return ""  + postfix(current.leftChild) + postfix(current.rightChild) + current.value;
		}

		//method used for tree analysis, not used in main method
		public int numNodes(Node current){
			if(current == null){
				return 0;
			}
			return 1 + numNodes(current.leftChild) + numNodes(current.rightChild);
		}

		public int numLevels(Node current, int currentLevel){
			if(current == null) return currentLevel;
			currentLevel+=1;
			return Math.max(numLevels(current.leftChild, currentLevel), numLevels(current.rightChild, currentLevel));

		}





	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("in.txt"));
		HashMap<ArrayList<Boolean>, Integer> shapes = new HashMap<ArrayList<Boolean>, Integer>();

		String[] input = sc.nextLine().split(" ");
		int iters = Integer.parseInt(input[0]);

		for(int i=0; i<iters; i++){

			String[] nodes = sc.nextLine().split(" ");
			int num = Integer.parseInt(nodes[0]);
			Tree t = new Tree();
			for(String x : nodes){
				int val = Integer.parseInt(x);
				t.add(new Node(val));
			}

			t.postfix(t.root);

			if(shapes.containsKey(t.shape)){
				shapes.put(t.shape, shapes.get(t.shape)+1);
				continue;
			}
			shapes.put(t.shape, 1);

	}

	System.out.println(shapes.size());
}


}