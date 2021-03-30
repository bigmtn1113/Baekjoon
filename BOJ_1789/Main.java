import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long s = sc.nextLong() * 2;
		
		sc.close();
		
		long num = (long) Math.sqrt(s);
		
		while (true) {
			long temp = num * num;
			
			if (temp >= s) {
				--num;
				
				if (num * (num + 1) > s) {
					--num;
				}
				
				break;
			}
			
			++num;
		}
		
		System.out.print(num);
	}
	
}
