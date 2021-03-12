import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String word = sc.next();
		
		sc.close();
		
		String cambridge = "CAMBRIDGE";
		ArrayList<Character> wordAfterCensorship = new ArrayList<>();
		
		for (int i = 0; i < word.length(); ++i) {
			char c = word.charAt(i);
			boolean check = false;
			
			for (int j = 0; j < 9; ++j) {
				if (cambridge.charAt(j) == c) {
					check = true;
					break;
				}
			}
			
			if (!check) {
				wordAfterCensorship.add(c);
			}
		}
		
		for (char c : wordAfterCensorship) {
			System.out.print(c);
		}
	}
	
}
