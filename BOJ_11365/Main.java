import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String cipher = sc.nextLine();
			
			if (cipher.equals("END")) {
				break;
			}
			
			ArrayList<Character> inputList = new ArrayList<>();
			
			for (int i = 0; i < cipher.length(); ++i) {
				inputList.add(cipher.charAt(i));
			}
			
			Collections.reverse(inputList);
			
			for (char input : inputList) {
				System.out.print(input);
			}
			
			System.out.println();
		}
		
		sc.close();
	}
	
}
