import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int r = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		int[][] concertHall = new int[r][c];
		
		int rowStartIndex = r - 1;
		int rowEndIndex = 0;
		int colStartIndex = 0;
		int colEndIndex = c - 1;
		
		int cnt = 0;
		
		while (cnt < r * c) {
			for (int i = rowStartIndex; i >= rowEndIndex; --i) {
				if (concertHall[i][colStartIndex] == 0) {
					concertHall[i][colStartIndex] = ++cnt;
				}
				
				if (cnt == k) {
					System.out.print((colStartIndex + 1) + " " + (r - i));
					System.exit(0);
				}
			}
			
			for (int i = colStartIndex; i <= colEndIndex; ++i) {
				if (concertHall[rowEndIndex][i] == 0) {
					concertHall[rowEndIndex][i] = ++cnt;
				}
				
				if (cnt == k) {
					System.out.print((i + 1) + " " + (r - rowEndIndex));
					System.exit(0);
				}
			}
			
			for (int i = rowEndIndex; i <= rowStartIndex; ++i) {
				if (concertHall[i][colEndIndex] == 0) {
					concertHall[i][colEndIndex] = ++cnt;
				}
				
				if (cnt == k) {
					System.out.print((colEndIndex + 1) + " " + (r - i));
					System.exit(0);
				}
			}
			
			for (int i = colEndIndex; i >= colStartIndex; --i) {
				if (concertHall[rowStartIndex][i] == 0) {
					concertHall[rowStartIndex][i] = ++cnt;
				}
				
				if (cnt == k) {
					System.out.print((i + 1) + " " + (r - rowStartIndex));
					System.exit(0);
				}
			}
			
			--rowStartIndex;
			++rowEndIndex;
			++colStartIndex;
			--colEndIndex;
		}
		
		System.out.print(0);
	}
	
}
