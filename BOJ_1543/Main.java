import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String document = sc.nextLine();
		String word = sc.nextLine();
		
		sc.close();
		
		int answer = 0;
		
		for (int i = 0; i < document.length(); ++i) {
			if (document.length() - i < word.length()) {
				break;
			}
			
			boolean check = true;
			
			for (int j = 0; j < word.length(); ++j) {
				if (word.charAt(j) != document.charAt(i + j)) {
					check = false;
					break;
				}
			}
			
			if (check) {
				i += word.length() - 1;
				++answer;
			}
		}
		
		System.out.print(answer);
	}

}
