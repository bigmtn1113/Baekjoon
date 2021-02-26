import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int[] records = new int[7];
		
		while (t > 0) {
			for (int i = 0; i < 7; ++i) {
				records[i] = sc.nextInt();
			}
			
			int sum = 0;
			
			sum += 9.23076 * Math.pow((26.7 - records[0]), 1.835);
			sum += 4.99087 * Math.pow((42.5 - records[3]), 1.81);
			sum += 0.11193 * Math.pow((254 - records[6]), 1.88);
			sum += 1.84523 * Math.pow((records[1] - 75), 1.348);
			sum += 56.0211 * Math.pow((records[2] - 1.5), 1.05);
			sum += 0.188807 * Math.pow((records[4] - 210), 1.41);
			sum += 15.9803 * Math.pow((records[5] - 3.8), 1.04);
			
			System.out.println(sum);
			
			--t;
		}
		
		sc.close();
	}
	
}
