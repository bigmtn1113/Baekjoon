import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] sticks = new int[3];
		int maxStick = 0;
		int maxStickIndex = 0;
		
		for (int i = 0; i < 3; ++i) {
			sticks[i] = sc.nextInt();
			
			maxStick = Math.max(maxStick, sticks[i]);
			
			if (maxStick == sticks[i]) {
				maxStickIndex = i;
			}
		}
		
		int twoStickLengthsum = 0;
		
		for (int i = 0; i < 3; ++i) {
			if (i != maxStickIndex) {
				twoStickLengthsum += sticks[i];
			}
		}
		
		int perimeter = 0;
		
		if (twoStickLengthsum > maxStick) {
			perimeter = twoStickLengthsum + maxStick;
		} else {
			perimeter = twoStickLengthsum * 2 - 1;
		}
		
		sc.close();
		
		System.out.print(perimeter);
	}
	
}
