import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		sc.close();
		
		int joiCnt = 0;
		int ioiCnt = 0;
		
		for (int i = 2; i < input.length(); ++i) {
			char c1 = input.charAt(i - 2);
			char c2 = input.charAt(i - 1);
			char c3 = input.charAt(i);
			
			if ((c2 != 'O') || (c3 != 'I')) {
				continue;
			}
			
			if (c1 == 'J') {
				++joiCnt;
			} else if (c1 == 'I') {
				++ioiCnt;
			}
		}
		
		System.out.print(joiCnt + "\n" + ioiCnt);
	}
	
}
