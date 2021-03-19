import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] inputs = new String[n];
		
		for (int i = 0; i < n; ++i) {
			inputs[i] = sc.next();
		}
		
		sc.close();
		
		String answer = "";
		
		for (int i = 0; i < inputs[0].length(); ++i) {
			char c = inputs[0].charAt(i);
			int cnt = 1;
			
			for (int j = 1; j < inputs.length; ++j) {
				if (c == inputs[j].charAt(i)) {
					++cnt;
				}
			}
			
			if (cnt == n) {
				answer += c;
			} else {
				answer += "?";
			}
		}
		
		System.out.print(answer);
	}
	
}
