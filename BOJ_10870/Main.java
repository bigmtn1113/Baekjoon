import java.util.Scanner;

public class Main {

	public static int fibonachi(int x) {
		if (x == 0 || x == 1) return x;
		
		return fibonachi(x - 1) + fibonachi(x - 2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		
		System.out.print(fibonachi(n));
	}

}
