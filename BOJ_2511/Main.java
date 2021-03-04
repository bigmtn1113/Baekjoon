import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[10];
		int[] b = new int[10];
		
		for (int i = 0; i < 10; ++i) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 10; ++i) {
			b[i] = sc.nextInt();
		}
		
		sc.close();
		
		int aScore = 0;
		int bScore = 0;
		char lastWinner = 'D';
		
		for (int i = 0; i < 10; ++i) {
			if (a[i] > b[i]) {
				aScore += 3;
				lastWinner = 'A';
			} else if (a[i] == b[i]) {
				++aScore;
				++bScore;
			} else {
				bScore += 3;
				lastWinner = 'B';
			}
		}
		
		if (aScore > bScore) {
			lastWinner = 'A';
		} else if (aScore < bScore) {
			lastWinner = 'B';
		}
		
		System.out.print(aScore + " " + bScore + "\n" + lastWinner);
	}
	
}
