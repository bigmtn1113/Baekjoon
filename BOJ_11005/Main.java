import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int b = sc.nextInt();
		
		System.out.print(Integer.toString(n, b).toUpperCase());
		
		sc.close();
	}
	
}
