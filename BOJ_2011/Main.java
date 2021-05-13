import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		sc.close();
		
		// 암호가 0으로 시작하거나 앞에 두 글자가 해독할 수 없는 암호일 경우
		// ex) 01234, 50123
		if ((s.charAt(0) - '0' == 0)
				|| ((s.length() >= 2) && (s.charAt(1) - '0' == 0) && (Integer.parseInt(s.substring(0, 2)) > 26))) {
			System.out.print(0);
			System.exit(0);
		}
		
		int[] dp = new int[5001];
		
		dp[1] = 1;
		
		if (s.length() >= 2) {
			 String temp = s.substring(0, 2);
			 
			 // 두번째 숫자가 0이거나 앞에 두 글자가 해독할 수 없는 암호일 경우 1, 아니면 2
			 // ex) 20134, 51245 -> 1
			 // ex) 214, 12345 -> 2
			 dp[2] = ((s.charAt(1) - '0' == 0) || (Integer.parseInt(temp) > 26)) ? 1 : 2;
		}
		
		int sLength = s.length();
		
		for (int i = 3; i <= sLength; ++i) {
			String temp = s.substring(i - 2, i);
			
			// i번째 숫자가 0이면서 i - 1번째와 합쳤을 때 해독할 수 없는 암호일 경우
			// ex) xxx50xx
			if ((s.charAt(i - 1) - '0' == 0) && (Integer.parseInt(temp) > 26)) {
				break;
			}
			
			// i번째 숫자가 0이 아닐 경우
			if (s.charAt(i - 1) - '0' != 0) {
				dp[i] = dp[i - 1];
			}
			
			// i - 1번째 숫자가 0이 아니면서 i번째 숫자와 합쳤을 때 해독할 수 있는 암호일 경우
			if ((temp.charAt(0) - '0' != 0) && (Integer.parseInt(temp) <= 26)) {
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;
			}
		}
		
		System.out.print((dp[sLength] > 0) ? dp[sLength] : 0);
	}

}
