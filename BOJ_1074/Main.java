import java.util.Scanner;

public class Main {
	
	public static void findRC(int i, int j, int visitNum, int size, int r, int c) {
		if (size == 1) {
			if ((i == r) && (j == c)) {
				System.out.print(visitNum);
			}
			
			return;
		}
		
		int halfSize = size / 2;
		
		if ((i <= r) && (r < i + halfSize) && (j <= c) && (c < j + halfSize)) {
			findRC(i, j, visitNum, halfSize, r, c);
			return;
		}
		
		if ((i <= r) && (r < i + halfSize) && (j + halfSize <= c) && (c < j + size)) { 
			findRC(i, j + halfSize, visitNum + halfSize * halfSize, halfSize, r, c);
			return;
		}
		
		if ((i + halfSize <= r) && (r < i + size) && (j <= c) && (c < j + halfSize)) {
			findRC(i + halfSize, j, visitNum + halfSize * halfSize * 2, halfSize, r, c);
			return;
		}
		
		findRC(i + halfSize, j + halfSize, visitNum + halfSize * halfSize * 3, halfSize, r, c);
		return;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		
		findRC(0, 0, 0, (int) Math.pow(2, n), r, c);
	}

}
