import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] students = new int[7][2];
		
		for (int i = 0; i < n; ++i) {
			int s = sc.nextInt();
			int y = sc.nextInt();
			
			++students[y][s];
		}
		
		sc.close();
		
		int temp = students[1][0] + students[1][1] + students[2][0] + students[2][1];
		int roomCnt = (temp % k == 0) ? temp / k : temp / k + 1;
		
		for (int i = 3; i < 7; i += 2) {
			for (int j = 0; j < 2; ++j) {
				temp = students[i][j] + students[i + 1][j];
				roomCnt += (temp % k == 0) ? temp / k : temp / k + 1;
			}
		}
		
		System.out.print(roomCnt);
	}
	
}
