import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < t; ++i) {
			String[] input = sc.nextLine().split(" ");
			
			double result = Double.parseDouble(input[0]);
			
			for (int j = 1; j < input.length; ++j) {
				switch (input[j].charAt(0)) {
				case '@':
					result *= 3;
					break;
					
				case '%':
					result += 5;
					break;

				default:
					result -= 7;
					break;
				}
			}
			
			System.out.format("%.2f\n", result);
		}
		
		sc.close();
	}
	
}
