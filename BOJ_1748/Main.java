import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int nDigit = (int) Math.log10(n) + 1;
		
		int answer = (n - (int) Math.pow(10, nDigit - 1) + 1) * nDigit;
		
		for (int i = nDigit - 1; i > 0; --i) {
			answer += i * (Math.pow(10, i) - Math.pow(10, i - 1));
		}
		
		System.out.print(answer);
	}

}
