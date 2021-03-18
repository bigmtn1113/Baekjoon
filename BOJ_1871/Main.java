import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			String[] licensePlate = sc.next().split("-");
			
			int sum = 0;
			
			for (int j = 0; j < 3; ++j) {
				sum += (licensePlate[0].charAt(j) - 'A') * Math.pow(26, 2 - j);
			}
			
			int result = Math.abs(sum - Integer.parseInt(licensePlate[1]));
			
			System.out.println((result <= 100) ? "nice" : "not nice");
		}
		
		sc.close();
	}
	
}
