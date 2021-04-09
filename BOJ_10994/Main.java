import java.util.Scanner;

public class Main {
	
	public static void makeStars(char[][] starArray, int n, int beginI, int beginJ) {
		if (n == 1) {
			starArray[beginI][beginJ] = '*';
			return;
		}
		
		int end = n * 4 - 3;
		
		for (int i = beginI; i < beginI + end; ++i) {
			for (int j = beginJ; j < beginJ + end; ++j) {
				if ((i == beginI) || (i == beginI + end - 1)) {
					starArray[i][j] = '*';
				} else {
					if ((j == beginJ) || (j == beginJ + end - 1)) {
						starArray[i][j] = '*';
					}
				}
			}
		}
		
		makeStars(starArray, n - 1, beginI + 2, beginJ + 2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		char[][] starArray = new char[n * 4 - 3][n * 4 - 3];
		
		makeStars(starArray, n, 0, 0);
		
		StringBuilder answer = new StringBuilder();
		
		for (char[] i : starArray) {
			for (char j : i) {
				answer.append((j == '*') ? j : ' ');
			}
			answer.append("\n");
		}
		
		System.out.print(answer);
	}

}
