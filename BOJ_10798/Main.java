import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String[] array = new String[5];
		
		int wordMaxLength = 0;
		
		for (int i = 0; i < 5; ++i) {
			array[i] = sc.next();
			
			wordMaxLength = Math.max(wordMaxLength, array[i].length());
		}
		
		sc.close();
		
		for (int i = 0; i < wordMaxLength; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (i < array[j].length()) {
					System.out.print(array[j].charAt(i));
				}
			}
		}
	}
	
}
