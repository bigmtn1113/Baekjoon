import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		int maxWidth = 0;
		int maxHeight = 0;
		int maxWidthIndex = 0;
		int maxHeightIndex = 0;
		
		int[] input = new int[6];
		
		for (int i = 0; i < 6; ++i) {
			int direction = sc.nextInt();
			int length = sc.nextInt();
			
			input[i] = length;
			
			if ((direction == 1) || (direction == 2)) {
				if (length > maxWidth) {
					maxWidth = length;
					maxWidthIndex = i;
				}
			} else {
				if (length > maxHeight) {
					maxHeight = length;
					maxHeightIndex = i;
				}
			}
		}
		
		sc.close();
		
		System.out.print(k * (maxWidth * maxHeight - (input[(maxWidthIndex + 3) % 6] * input[(maxHeightIndex + 3) % 6])));
	}
	
}
