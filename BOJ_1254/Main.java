import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static boolean isPalindrome(ArrayList<Character> list) {
		int left = 0;
		int right = list.size() - 1;
		
		while (left <= right) {
			if (list.get(left) != list.get(right)) {
				return false;
			}
			
			++left;
			--right;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] s = sc.next().toCharArray();
		
		sc.close();
		
		ArrayList<Character> list = new ArrayList<>();
		
		for (int i = 0;i < s.length; ++i) {
			list.add(s[i]);
		}
		
		int sLength = s.length;
		
		for (int i = 0; i < sLength; ++i) {
			if (isPalindrome(list)) {
				break;
			}
			
			list.add(list.size() - i, list.get(i));
		}
		
		System.out.print(list.size());
	}

}
