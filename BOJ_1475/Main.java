import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		
		sc.close();
		
		int[] numArray = new int[10];
		
		for (int i = 0; i < n.length(); ++i) {
			++numArray[n.charAt(i) - '0'];
		}
		
		int setCnt = 0;
		
		for (int i = 0; i < 10; ++i) {
			if ((i != 6) && (i != 9)) {
				setCnt = Math.max(setCnt, numArray[i]);
			}
		}
		
		int sixOrNineCnt = numArray[6] + numArray[9];
		
		sixOrNineCnt = (sixOrNineCnt % 2 == 0) ? sixOrNineCnt / 2 : sixOrNineCnt / 2 + 1;

		System.out.print(Math.max(setCnt, sixOrNineCnt));
	}
	
}
