import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String binaryNum1 = sc.next();
			String binaryNum2 = sc.next();
			
			int hammingDistance = 0;
			
			for (int j = 0; j < binaryNum1.length(); ++j) {
				if (binaryNum1.charAt(j) != binaryNum2.charAt(j)) {
					++hammingDistance;
				}
			}
			
			System.out.println("Hamming distance is " + hammingDistance + ".");
		}
		
		sc.close();
	}
	
}
