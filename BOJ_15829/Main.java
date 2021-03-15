import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		String input = sc.next();
		
		sc.close();
		
		double answer = 0;
		double r = 1;
		
		for (int i = 0; i < l; ++i) {
			answer = (answer + (input.charAt(i) - 'a' + 1) * r) % 1234567891;
			r = (r * 31) % 1234567891;
		}
		
		System.out.format("%.0f", answer);
	}
	
}
