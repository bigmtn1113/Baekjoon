import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] previousXY = {sc.nextInt(), sc.nextInt()};
		
		int[] startXY = {previousXY[0], previousXY[1]};
		int perimeter = 0;
		
		while (n > 1) {
			int[] xy = {sc.nextInt(), sc.nextInt()};
			
			perimeter += Math.abs(xy[0] - previousXY[0]) + Math.abs(xy[1] - previousXY[1]);
			
			previousXY[0] = xy[0];
			previousXY[1] = xy[1];
			
			--n;
		}
		
		sc.close();
		
		perimeter += Math.abs(startXY[0] - previousXY[0]) + Math.abs(startXY[1] - previousXY[1]);
		
		System.out.print(perimeter);
	}
	
}
