import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int location = sc.nextInt();
			String typoWord = sc.next();
			
			for (int j = 0; j < typoWord.length(); ++j) {
				if (j == location - 1) {
					continue;
				}
				
				System.out.print(typoWord.charAt(j));
			}
			
			System.out.println();
		}
		
		sc.close();
	}
	
}
