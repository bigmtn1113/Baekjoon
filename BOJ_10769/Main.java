import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine() + "  ";
		
		sc.close();
		
		int happyCnt = 0;
		int sadCnt = 0;
		
		for (int i = 0; i < input.length(); ++i) {
			char c = input.charAt(i);
			
			if ((c == ':') && (input.charAt(i + 1) == '-')) {
				if (input.charAt(i + 2) == ')') {
					++happyCnt;
				} else if (input.charAt(i + 2) == '(') {
					++sadCnt;
				}
			}
		}
		
		if ((happyCnt == 0) && (sadCnt == 0)) {
			System.out.print("none");
		} else if (happyCnt == sadCnt) {
			System.out.print("unsure");
		} else if (happyCnt > sadCnt) {
			System.out.print("happy");
		} else {
			System.out.print("sad");
		}
	}
	
}
