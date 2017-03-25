import java.util.*;
import java.io.*;

public class Pass{

	public static class Tri implements Comparable<Tri>{
		String name;
		public Tri(String name){
			this.name = name;
		}

		public int compareTo(Tri other){
			return this.name.substring()
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int perms = sc.nextInt();
		ArrayList<String> words = new ArrayList<String>();
		sc.nextLine();
		for(int i=0; i<perms; i++){
			words.add(sc.nextLine());
		}

		boolean found = false;
		
		for(int i=0; i<words.size(); i++){
			String curr = words.get(i);
			String pass = "";
			pass+=curr;

			ArrayList<String> temp = new ArrayList<String>(words);

			temp.remove(curr);
			int index = 0;
			while(true){

				if(temp.size() == 0)
					break;
				if(index == temp.size()){
					break;
				}
				if(temp.get(index).substring(0, 2).equals(pass.substring(pass.length()-2, pass.length()))){
					pass+=temp.get(index).charAt(temp.get(index).length()-1);
					temp.remove(index);
					index = 0;
				}else{
					index+=1;
				}
			}

			if(temp.size() == 0){
				System.out.println("YES\n" + pass);
				found = true;
				break;
			}


		}

		if(!found){
			System.out.println("NO");
		}

	}
}