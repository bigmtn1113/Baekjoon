import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		long answer = (long) a * b;
		
		while (a % b > 0) {
			int temp = a;
			a = b;
			b = temp % b;
		}
		
		System.out.print(answer / b);
	}

}
