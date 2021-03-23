import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] players = new int[n][3];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 3; ++j) {
				players[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		int[] sum = new int[n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < 3; ++j) {
				boolean check = false;
				
				for (int k = 0; k < n; ++k) {
					if (i == k) {
						continue;
					}
					
					if (players[i][j] == players[k][j]) {
						check = true;
						break;
					}
				}
				
				if (!check) {
					sum[i] += players[i][j];
				}
			}
		}
		
		for (int i : sum) {
			System.out.println(i);
		}
	}
	
}
