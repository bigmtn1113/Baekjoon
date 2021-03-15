import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int[] parkingTime = new int[101];
		
		for (int i = 0; i < 3; ++i) {
			int beginTime = sc.nextInt();
			int endTime = sc.nextInt();
			
			for (int j = beginTime; j < endTime; ++j) {
				++parkingTime[j];
			}
		}
		
		sc.close();
		
		int sum = 0;
		
		for (int i : parkingTime) {
			switch (i) {
			case 1:
				sum += a;
				break;
				
			case 2:
				sum += i * b;
				break;

			case 3:
				sum += i * c;
				break;

			default:
				break;
			}
		}
		
		System.out.print(sum);
	}
	
}
