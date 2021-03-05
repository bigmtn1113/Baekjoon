import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String n = sc.next();
			
			if (n.equals("0")) {
				break;
			}
			
			int sum = 0;
			
			while (true) {
				for (int i = 0; i < n.length(); ++i) {
					sum += n.charAt(i) - '0';
				}
				
				if (sum < 10) {
					break;
				}
				
				n = Integer.toString(sum);
				sum = 0;
			}
			
			System.out.println(sum);
		}
		
		sc.close();
	}
	
}
