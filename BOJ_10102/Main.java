import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		String input = sc.next();
		
		int aCnt = 0;
		int bCnt = 0;
		
		for (int i = 0; i < v; ++i) {
			if (input.charAt(i) == 'A') {
				++aCnt;
			} else {
				++bCnt;
			}
		}
		
		sc.close();
		
		if (aCnt > bCnt) {
			System.out.print("A");
		} else if (aCnt == bCnt) {
			System.out.print("Tie");
		} else {
			System.out.print("B");
		}
	}
	
}
