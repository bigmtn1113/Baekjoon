import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		
		sc.close();
		
		System.out.print((l % 5 == 0) ? (l / 5) : (l / 5 + 1));
	}
	
}
