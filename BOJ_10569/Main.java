import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t > 0) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			System.out.println(2 - (v - e));
			
			--t;
		}
		
		sc.close();
	}
	
}
