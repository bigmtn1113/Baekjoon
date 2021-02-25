import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] cup = {0, 1, 2, 3};
		
		int m = sc.nextInt();
		
		while (m > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int xIndex = 0;
			int yIndex = 0;
			
			for (int i = 1; i < 4; ++i) {
				if (cup[i] == x) {
					xIndex = i;
				} 
				
				if (cup[i] == y) {
					yIndex = i;
				}
			}
			
			int temp = cup[xIndex];
			cup[xIndex] = cup[yIndex];
			cup[yIndex] = temp;
			
			--m;
		}
		
		sc.close();
		
		System.out.print(cup[1]);
	}
	
}
