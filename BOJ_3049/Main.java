import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		System.out.print(n * (n - 1) * (n - 2) * (n - 3) / 24);
	}
	
}