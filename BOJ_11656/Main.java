import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		sc.close();
		
		String[] strArray = new String[s.length()];
		
		for (int i = 0; i < strArray.length; ++i) {
			strArray[i] = s.substring(i);
		}
		
		Arrays.sort(strArray);
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < strArray.length; ++i) {
			answer.append(strArray[i]).append("\n");
		}
		
		System.out.print(answer);
	}
	
}
