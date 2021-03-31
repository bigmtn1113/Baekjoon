import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] woodCarvings = new int[5];
		
		for (int i = 0; i < 5; ++i) {
			woodCarvings[i] = sc.nextInt();
		}
		
		sc.close();
		
		StringBuilder answer = new StringBuilder();
		
		while (true) {
			for (int i = 1; i < 5; ++i) {
				boolean changed = false;
				
				if (woodCarvings[i - 1] > woodCarvings[i]) {
					int temp = woodCarvings[i - 1];
					woodCarvings[i - 1] = woodCarvings[i];
					woodCarvings[i] = temp;
					
					changed = true;
				}
				
				if (changed) {
					for (int woodCarving : woodCarvings) {
						answer.append(woodCarving + " ");
					}
					
					answer.append("\n");
				}
			}
			
			if ((woodCarvings[0] == 1)
					&& (woodCarvings[1] == 2) && (woodCarvings[2] == 3)
					&& (woodCarvings[3] == 4) && (woodCarvings[4] == 5)) {
				break;
			}
		}
		
		System.out.print(answer);
	}
	
}
