import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int jimin = sc.nextInt();
		int hansu = sc.nextInt();
		
		sc.close();
		
		if (jimin > hansu) {
			int temp = jimin;
			jimin = hansu;
			hansu = temp;
		}
		
		boolean check = false;
		int answer = 1;
		
		while (n > 1) {
			if ((jimin % 2 == 1) && (hansu == jimin + 1)) {
				check = true;
				break;
			}
			
			jimin = (jimin % 2 == 0) ? jimin / 2 : jimin / 2 + 1;
			hansu = (hansu % 2 == 0) ? hansu / 2 : hansu / 2 + 1;
			
			++answer;
			n = (n % 2 == 0) ? n / 2 : n / 2 + 1;
		}
		
		System.out.print((check) ? answer : -1);
	}

}
