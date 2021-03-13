import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String word1 = sc.next();
			String word2 = sc.next();
			
			System.out.print("Distances: ");
			
			for (int j = 0; j < word1.length(); ++j) {
				char c1 = word1.charAt(j);
				char c2 = word2.charAt(j);
				
				System.out.print((c1 <= c2) ? (c2 - c1) + " " : (c2 - c1 + 26) + " ");
			}
			
			System.out.println();
		}
		
		sc.close();
	}
	
}
