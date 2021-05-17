import java.util.Scanner;

public class Main {
	
	public static boolean isPalindrome(char[] str, int left, int right) {
		while (left <= right) {
			if (str[left] == str[right]) {
				++left;
				--right;
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			char[] str = sc.next().toCharArray();
			
			int left = 0;
			int right = str.length - 1;
			
			int cnt = 0;
			
			while (left <= right) {
				if (str[left] == str[right]) {
					++left;
					--right;
					continue;
				}
				
				cnt = (isPalindrome(str, left + 1, right) || isPalindrome(str, left, right - 1)) ? 1 : 2;
				break;
			}
			
			if (cnt == 0) {
				answer.append("0").append("\n");
			} else if (cnt == 1) {
				answer.append("1").append("\n");
			} else {
				answer.append("2").append("\n");
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
