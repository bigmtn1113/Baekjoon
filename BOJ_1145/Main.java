import java.util.Scanner;

public class Main {
	
	public static int gcd(int num1, int num2) {
		if (num1 < num2) {
			int temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		while (num1 % num2 != 0) {
			int temp = num1;
			num1 = num2;
			num2 = temp % num2;
		}
		
		return num2;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] input = new int[5];
		
		for (int i = 0; i < 5; ++i) {
			input[i] = sc.nextInt();
		}
		
		sc.close();
		
		int minLcm = 1000000;
		
		for (int i = 0; i < 5; ++i) {
			for (int j = i + 1; j < 5; ++j) {
				int ijGcd = gcd(input[i], input[j]);
				int ijLcm = input[i] * input[j] / ijGcd;
				
				for (int k = j + 1; k < 5; ++k) {
					int ijkGcd = gcd(ijLcm, input[k]);
					int ijkLcm = ijLcm * input[k] / ijkGcd;
					
					minLcm = Math.min(minLcm, ijkLcm);
				}
			}
		}
		
		System.out.print(minLcm);
	}
	
}
