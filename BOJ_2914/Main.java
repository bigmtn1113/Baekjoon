import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int i = sc.nextInt();
		
		sc.close();
		
		System.out.print(a * (i - 1) + 1);
	}
	
}
