import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[] s = sc.next().toCharArray();
		
		sc.close();
		
		int answer = 0;
		int p = 0;
		
		for (int i = 2; i < m; ++i) {
			if ((s[i - 2] == 'I') && (s[i - 1] == 'O') && (s[i] == 'I')) {
				++p;
				
				if (p == n) {
					++answer;
					--p;
				}
				
				++i;
				continue;
			}
			
			p = 0;
		}
		
		System.out.print(answer);
	}

}
