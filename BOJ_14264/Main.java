import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		
		sc.close();
		
		System.out.format("%.9f", Math.sqrt(3) / 4 * l * l);
	}
	
}
