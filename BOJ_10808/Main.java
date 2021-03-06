import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		sc.close();
		
		int[] alphabet = new int[26];
		
		for (int i = 0; i < s.length(); ++i) {
			++alphabet[s.charAt(i) - 'a'];
		}
		
		for (int i = 0; i < 26; ++i) {
			System.out.print(alphabet[i] + " ");
		}
	}
	
}
