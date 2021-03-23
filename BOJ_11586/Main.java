import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] mirror = new String[n];
		
		for (int i = 0; i < n; ++i) {
			mirror[i] = sc.next();
		}
		
		int k = sc.nextInt();
		
		sc.close();
		
		switch (k) {
		case 2:
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < n; ++j) {
					System.out.print(mirror[i].charAt(n - 1 - j));
				}
				
				System.out.println();
			}
			break;
			
		case 3:
			for (int i = n - 1; i >= 0; --i) {
				System.out.println(mirror[i]);
			}
			break;

		default:
			for (int i = 0; i < n; ++i) {
				System.out.println(mirror[i]);
			}
			break;
		}
	}
	
}
