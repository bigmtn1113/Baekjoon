import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		if (m >= 45) System.out.print(h + " " + (m - 45));
		else {
			if (h == 0) System.out.print(23 + " " + (m + 15));
			else System.out.print((h - 1) + " " + (m + 15));
		}
	}

}
