import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] playerCnt = new int[26];
		
		for (int i = 0; i < n; ++i) {
			String playerLastName = sc.next();
			
			++playerCnt[playerLastName.charAt(0) - 'a'];
		}
		
		sc.close();
		
		boolean check = false;
		
		for (int i = 0; i < 26; ++i) {
			if (playerCnt[i] >= 5) {
				System.out.print((char) (i + 'a'));
				check = true;
			}
		}
		
		if (!check) {
			System.out.print("PREDAJA");
		}
	}
	
}
