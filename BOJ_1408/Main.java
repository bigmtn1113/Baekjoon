import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String[] now = sc.next().split(":");
		String[] mission = sc.next().split(":");
		
		int[] answer = new int[3];
		
		for (int i = 0; i < 3; ++i) {
			answer[i] = Integer.parseInt(mission[i]) - Integer.parseInt(now[i]);
			
			if (answer[i] < 0) {
				if (i > 0) {
					answer[i] += 60;
					--answer[i - 1];
				} else {
					answer[i] += 24;
				}
			}
		}
		
		sc.close();
		
		if (answer[1] < 0) {
			answer[1] += 60;
			--answer[0];
		}
		
		if (answer[0] < 0) {
			answer[0] += 24;
		}
		
		System.out.format("%02d:%02d:%02d", answer[0], answer[1], answer[2]);
	}
	
}
