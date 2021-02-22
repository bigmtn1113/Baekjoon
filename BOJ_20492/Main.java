import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		System.out.print((int) (n - (n * 0.22)) + " " + (int) (n - (n * 0.2 * 0.22)));
	}
	
}
