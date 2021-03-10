import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		boolean[] input = new boolean[31];
		
		for (int i = 0; i < 28; ++i) {
			input[sc.nextInt()] = true;
		}
		
		sc.close();
		
		for (int i = 1; i <= 30; ++i) {
			if (!input[i]) {
				System.out.println(i);
			}
		}
	}
	
}
