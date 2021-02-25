import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		while (n > 0) {
			int k = sc.nextInt();
			
			while (k > 0) {
				System.out.print("=");
				
				--k;
			}
			
			System.out.println();
			
			--n;
		}
		
		sc.close();
	}
	
}
