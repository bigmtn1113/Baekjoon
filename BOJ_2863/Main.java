import java.util.Scanner;

public class Main {
	
	public static int[][] input = new int[2][2];
	
	public static int[][] rotate() {
		int[][] temp = new int[2][2];
		
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				temp[j][1 - i] = input[i][j];
			}
		}
		
		return temp;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 2; ++j) {
				input[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		double maxSum = (double) input[0][0] / input[1][0] + (double) input[0][1] / input[1][1];
		int rotationCnt = 0;
		
		for (int rotation = 1; rotation <= 3; ++rotation) {
			input = rotate();
			
			double tempSum = (double) input[0][0] / input[1][0] + (double) input[0][1] / input[1][1];
			
			if (tempSum > maxSum) {
				maxSum = tempSum;
				rotationCnt = rotation;
			}
		}
		
		System.out.print(rotationCnt);
	}
	
}
