import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		sc.close();
		
		int bNumSum = 0;
		long answer = 0;
		
		for (int i = 0; i < b.length(); ++i) {
			bNumSum += b.charAt(i) - '0';
		}
		
		for (int i = 0; i < a.length(); ++i) {
			answer += (a.charAt(i) - '0') * bNumSum;
		}
		
		System.out.print(answer);
	}
	
}
