import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sc.close();
		
		if (n == 1) {
			System.out.print(1);
		} else if (n == 2){
			System.out.print(Math.min(4, (m + 1) / 2));
		} else if (m < 7) {
			System.out.print(Math.min(4, m));
		} else {
			System.out.print(m - 2);
		}
	}

}
