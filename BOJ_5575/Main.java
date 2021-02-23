import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[][] input = new int[3][6];
		
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 6; ++j) {
				input[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		for (int i = 0; i < 3; ++i) {
			input[i][0] = input[i][3] - input[i][0];
			input[i][1] = input[i][4] - input[i][1];
			input[i][2] = input[i][5] - input[i][2];
			
			if (input[i][2] < 0) {
				--input[i][1];
				input[i][2] += 60;
			}
			
			if (input[i][1] < 0) {
				--input[i][0];
				input[i][1] += 60;
			}
			
			System.out.println(input[i][0] + " " + input[i][1] + " " + input[i][2]);
		}
	}
	
}
