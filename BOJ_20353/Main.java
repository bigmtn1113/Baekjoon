import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		
		sc.close();
		
		System.out.format("%.6f", Math.sqrt(a) * 4);
	}
	
}
