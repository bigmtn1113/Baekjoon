import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sc.close();
		
		int cnt = n;
		
		while (true) {
			cnt += n /= m;
			
			if (n < m) {
				System.out.print(cnt);
				break;
			}
		}
	}
	
}
