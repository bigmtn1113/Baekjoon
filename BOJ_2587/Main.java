import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] input = new int[5];
		int sum = 0;
		
		for (int i = 0; i < 5; ++i) {
			input[i] = sc.nextInt();
			
			sum += input[i];
		}
		
		sc.close();
		
		Arrays.sort(input);
		
		System.out.print(sum / 5 + "\n" + input[2]);
	}
	
}
