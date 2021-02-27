import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int m = sc.nextInt();
		
		int i = 1;
		
		while (true) {
			if (i * a % m == 1) {
				System.out.print(i);
				break;
			}
			
			++i;
		}
		
		sc.close();
	}
	
}
