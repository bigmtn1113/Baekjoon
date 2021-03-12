import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; ++i) {
			String input = sc.nextLine();
			
			char firstC = input.charAt(0);
			
			if (('A' <= firstC) && (firstC <= 'Z')) {
				System.out.println(input);
			} else {
				System.out.println(input.replaceFirst(Character.toString(firstC), Character.toString((char) (firstC - 32))));
			}
		}
		
		sc.close();
	}
	
}
