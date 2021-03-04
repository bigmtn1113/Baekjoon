import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int d = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();
		
		if (((k - a) % d != 0) || ((k - a) / d < 0)) {
			System.out.print("X");
		} else {
			System.out.print((k - a) / d + 1);
		}
	}
	
}
