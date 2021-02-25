import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		sc.close();
		
		int[] num1Coordinates = new int[2];
		int[] num2Coordinates = new int[2];
		
		if (num1 % 4 == 0) {
			num1Coordinates[0] = num1 / 4;
			num1Coordinates[1] = 4;
		} else {
			num1Coordinates[0] = num1 / 4 + 1;
			num1Coordinates[1] = num1 % 4;
		}
		
		if (num2 % 4 == 0) {
			num2Coordinates[0] = num2 / 4;
			num2Coordinates[1] = 4;
		} else {
			num2Coordinates[0] = num2 / 4 + 1;
			num2Coordinates[1] = num2 % 4;
		}
		
		int result = Math.abs(num1Coordinates[0] - num2Coordinates[0]) + Math.abs(num1Coordinates[1] - num2Coordinates[1]);
		
		System.out.print(result);
	}
	
}
