import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] students = new int[7][2];
		int roomCnt = 0;
		
		for (int i = 0; i < n; ++i) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			++students[y][s];
		}
		
		sc.close();
		
		for (int i = 1; i <= 6; ++i) {
			roomCnt += Math.ceil((double) students[i][0] / k) + Math.ceil((double) students[i][1] / k);
		}
		
		System.out.print(roomCnt);
	}
	
}
