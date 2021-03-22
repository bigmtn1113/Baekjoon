import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		
		sc.close();
		
		int aCnt = 1;
		int bCnt = 0;
		
		for (int i = 1; i <= k; ++i) {
			int temp = aCnt;
			aCnt = bCnt;
			bCnt += temp;
		}
		
		System.out.print(aCnt + " " + bCnt);
	}
	
}
