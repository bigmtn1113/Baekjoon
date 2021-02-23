import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int piece = 2;
		int plus = 2;
		boolean sw = false;
		
		for (int i = 2; i <= n; ++i) {
			piece += plus;
			
			if (sw == true) {
				++plus;
				sw = false;
				
				continue;
			}
			
			sw = true;
		}
		
		System.out.print(piece);
	}
	
}
