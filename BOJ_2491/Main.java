import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		int answer = 1;
		int sequenceLength = 1;
		
		for (int i = 1; i < n; ++i) {
			if (array[i] >= array[i - 1]) {
				++sequenceLength;
				continue;
			}
			
			answer = Math.max(answer, sequenceLength);
			sequenceLength = 1;
		}
		
		answer = Math.max(answer, sequenceLength);
		sequenceLength = 1;
		
		for (int i = 1; i < n; ++i) {
			if (array[i] <= array[i - 1]) {
				++sequenceLength;
				continue;
			}
			
			answer = Math.max(answer, sequenceLength);
			sequenceLength = 1;
		}
		
		System.out.print(Math.max(answer, sequenceLength));
	}

}
