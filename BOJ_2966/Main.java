import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String examAnswer = sc.next();
		
		sc.close();
		
		char[] adrian = {'A', 'B', 'C'};
		char[] bruno = {'B', 'A', 'B', 'C'};
		char[] goran = {'C', 'C', 'A', 'A', 'B', 'B'};
		
		int[] answer = new int[3];
		int maxCnt = 0;
		
		for (int i = 0; i < n; ++i) {
			char c = examAnswer.charAt(i);
			
			if (c == adrian[i % 3]) {
				++answer[0];
			}
			
			if (c == bruno[i % 4]) {
				++answer[1];
			}
			
			if (c == goran[i % 6]) {
				++answer[2];
			}
			
			maxCnt = Math.max(Math.max(Math.max(maxCnt, answer[0]), answer[1]), answer[2]);
		}
		
		System.out.println(maxCnt);
		
		for (int i = 0; i < 3; ++i) {
			if (answer[i] == maxCnt) {
				switch (i) {
				case 0:
					System.out.println("Adrian");
					break;
					
				case 1:
					System.out.println("Bruno");
					break;

				default:
					System.out.print("Goran");
					break;
				}
			}
		}
	}
	
}
