import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] s = new String[n];
		
		for (int i = 0; i < n; ++i) {
			s[i] = sc.next();
		}
		
		sc.close();
		
		Arrays.sort(s, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}
				
				int o1Sum = 0;
				int o2Sum = 0;
				
				for (int i = 0; i < o1.length(); ++i) {
					char c = o1.charAt(i);
					
					if (('0' <= c) && (c <= '9')) {
						o1Sum += c - '0';
					}
				}
				
				for (int i = 0; i < o2.length(); ++i) {
					char c = o2.charAt(i);
					
					if (('0' <= c) && (c <= '9')) {
						o2Sum += c - '0';
					}
				}
				
				if (o1Sum != o2Sum) {
					return o1Sum - o2Sum;
				}
				
				return o1.compareTo(o2);
			}
			
		});
		
		StringBuilder answer = new StringBuilder();
		
		for (String str : s) {
			answer.append(str).append("\n");
		}
		
		System.out.print(answer);
	}

}
