import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		for (int i = 1; i * i <= b; ++i) {
			if (b % i == 0) {
				int l = b / i + 2;
				int w = i + 2;
				
				if (r == (l * 2 + (w - 2) * 2)) {
					System.out.print(l + " " + w);
					System.exit(0);
				}
			}
		}
	}
	
}
