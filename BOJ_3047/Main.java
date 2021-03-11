import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] abc = new int[3];
		
		for (int i = 0; i < 3; ++i) {
			abc[i] = sc.nextInt();
		}
		
		Arrays.sort(abc);
		
		String input = sc.next();
		
		for (int i = 0; i < 3; ++i) {
			System.out.print(abc[input.charAt(i) - 'A'] + " ");
		}
		
		sc.close();
	}
	
}
