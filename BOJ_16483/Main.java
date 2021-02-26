import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		sc.close();
		
		System.out.format("%.0f", (double) t * t / 4);
	}
	
}
