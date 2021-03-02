import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = 0;
		
		for (int i = 0; i < n - 1; ++i) {
			cnt += sc.nextInt() - 1;
		}
		
		cnt += sc.nextInt();
		
		sc.close();
		
		System.out.print(cnt);
	}
	
}
