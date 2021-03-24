import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		sc.close();
		
		ArrayList<Character> ucpc = new ArrayList<>();
		
		ucpc.add('U');
		ucpc.add('C');
		ucpc.add('P');
		ucpc.add('C');
		
		int cnt = 0;
		
		for (int i = 0; i < input.length(); ++i) {
			if (input.charAt(i) == ucpc.get(0)) {
				++cnt;
				ucpc.remove(0);
				
				if (ucpc.isEmpty()) {
					break;
				}
			}
		}
		
		System.out.print((cnt == 4) ? "I love UCPC" : "I hate UCPC");
	}
	
}
