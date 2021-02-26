import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int num = 1;
		int repeatCnt = 1;
		
		while (num <= n) {
			int a = repeatCnt;
			
			for (int i = 1; i <= repeatCnt; ++i, ++num, --a) {
				if (num == n) {
					System.out.print(a + " " + i);
				}
			}
			
			++repeatCnt;
		}
	}
	
}
