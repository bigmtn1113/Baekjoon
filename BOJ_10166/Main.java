import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		
		sc.close();
		
		boolean[][] contained = new boolean[d2 + 1][d2 + 1];
		
		for (int i = d1; i <= d2; ++i) {		// 반지름
			for (int j = 1; j < i; ++j) {		// 좌석
				int tempJ = j;
				int tempI = i;
				
				while (tempJ > 0) {
					int temp = tempI;
					tempI = tempJ;
					tempJ = temp % tempJ;
				}
				
				int numerator = j / tempI;		// 기약분수 구하기. 분자
				int denominator = i / tempI;	// 기약분수 구하기. 분모
				
				if (!contained[numerator][denominator]) {
					contained[numerator][denominator] = true;
				}
			}
		}
		
		int answer = 1;
		
		for (int i = 2; i <= d2; ++i) {
			for (int j = 1; j < i; ++j) {
				if (contained[j][i]) {
					++answer;
				}
			}
		}
		
		System.out.print(answer);
	}

}
