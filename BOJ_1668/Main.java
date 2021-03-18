import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] trophy = new int[n];
		
		for (int i = 0; i < n; ++i) {
			trophy[i] = sc.nextInt();
		}
		
		sc.close();
		
		int leftViewCnt = 1;
		int bigTrophy = trophy[0];
		
		for (int i = 1; i < n; ++i) {
			if (trophy[i] <= bigTrophy) {
				continue;
			}
			
			bigTrophy = trophy[i];
			++leftViewCnt;
		}
		
		int rightViewCnt = 1;
		bigTrophy = trophy[n - 1];
		
		for (int i = n - 2; i >= 0; --i) {
			if (trophy[i] <= bigTrophy) {
				continue;
			}
			
			bigTrophy = trophy[i];
			++rightViewCnt;
		}
		
		System.out.print(leftViewCnt + "\n" + rightViewCnt);
	}
	
}
