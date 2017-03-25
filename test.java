import java.util.Scanner;
import java.io.File;

public class test{

	public static void printMat(char[][] maze){
		for(int i=0; i<maze.length; i++){
			for(int j=0; j<maze[0].length; j++){
				System.out.print(maze[i][j]);
			}

			System.out.println();
		}
	}

	public static boolean inBounds(char[][] maze, int i, int j){
		return i < maze.length && i >= 0 && j < maze[0].length && j >= 0;
	}

	public static boolean checkAround(char[][] maze, int i, int j){
		return (inBounds(maze, i, j-1) && maze[i][j-1] == '.') || 
		(inBounds(maze, i, j+1) && maze[i][j+1] == '.')  ||
		(inBounds(maze, i-1, j) && maze[i-1][j] == '.')  ||
		(inBounds(maze, i+1, j) && maze[i+1][j] == '.');
	}

	public static boolean isConnected(char[][] maze){

		for(int i=0; i<maze.length; i++){
			for(int j=0; j<maze[0].length; j++){
				if(maze[i][j] == '.'){
					
				}
			}
		}
	}


	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("test.txt"));
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		int walls = sc.nextInt();

		sc.nextLine();
		char[][] maze = new char[rows][cols];

		for(int i=0; i<rows; i++){
			maze[i] = sc.nextLine().toCharArray();

		}

		char[][] temp = new char[rows][cols];
		temp = maze;






		while(walls > 0){
			
	LOOP:	for(int i=0; i<rows; i++){
				for(int j=0; j<cols; j++){

					if(temp[i][j] == '.'){

						temp[i][j] = '#';
						if(isConnected(temp)){

							temp[i][j] = 'X';
							maze = temp;
							walls--;
							break LOOP;
						}else{
							temp[i][j] = '.';
						}
					}
				}
			}
			System.out.println("walls is at " + walls);
		}

		printMat(maze);



	}
}