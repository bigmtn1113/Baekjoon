import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		sc.close();
		
		ArrayList<Integer> stickList = new ArrayList<>();
		
		stickList.add(64);
		
		int sum = 65;
		int stickCnt = 0;
		
		while (sum > x) {
			int shortestStrick = stickList.remove(stickList.size() - 1) / 2;
			
			stickList.add(shortestStrick);
			
			sum = 0;
			stickCnt = 0;
			
			for (int stick : stickList) {
				sum += stick;
				++stickCnt;
			}
			
			if (sum < x) {
				stickList.add(shortestStrick);
				sum += shortestStrick;
			}
		}
		
		System.out.print(stickCnt);
	}
	
}
