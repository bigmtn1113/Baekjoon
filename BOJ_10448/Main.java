import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int k = sc.nextInt();
			
			int sum = 0;
			
			label: for (int x = 1; ; ++x) {
				int triangleFirstNum = x * (x + 1) / 2;
				
				sum += triangleFirstNum;
				
				for (int y = 1; ; ++y) {
					int triangleSecondNum = y * (y + 1) / 2;
					
					sum += triangleSecondNum;
					
					for (int z = 1; ; ++z) {
						int triangleThirdNum = z * (z + 1) / 2;
						
						sum += triangleThirdNum;
						
						if (sum == k) {
							System.out.println(1);
							break label;
						}
						
						if (sum > k) {
							sum -= triangleThirdNum;
							break;
						}
						
						sum -= triangleThirdNum;
					}
					
					if (sum > k) {
						sum -= triangleSecondNum;
						break;
					}
					
					sum -= triangleSecondNum;
				}
				
				if (sum > k) {
					System.out.println(0);
					break;
				}
				
				sum -= triangleFirstNum;
			}
		}
		
		sc.close();
	}
	
}
