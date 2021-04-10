import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] switchStateArray = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			switchStateArray[i] = sc.nextInt();
		}
		
		int studentNum = sc.nextInt();
		
		for (int i = 0; i < studentNum; ++i) {
			int sex = sc.nextInt();
			int receivedNum = sc.nextInt();
			
			if (sex == 1) {
				for (int j = receivedNum; j <= n; j += receivedNum) {
					switchStateArray[j] = (switchStateArray[j] - 1 == 0) ? 0 : 1;
				}
			} else {
				int left = receivedNum - 1;
				int right = receivedNum + 1;
				
				while ((left > 0) && (right <= n)) {
					if (switchStateArray[left] != switchStateArray[right]) {
						break;
					}
					
					--left;
					++right;
				}
				
				for (int j = left + 1; j <= right - 1; ++j) {
					switchStateArray[j] = (switchStateArray[j] - 1 == 0) ? 0 : 1;
				}
			}
		}
		
		sc.close();
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 1; i <= n; ++i) {
			answer.append(switchStateArray[i]).append(" ");
			
			if (i % 20 == 0) {
				answer.append("\n");
			}
		}
		
		System.out.print(answer);
	}

}
