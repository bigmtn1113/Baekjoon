import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int spareAppleCnt = 0;
		
		while (n > 0) {
			int studentCnt = sc.nextInt();
			int appleCnt = sc.nextInt();
			
			spareAppleCnt += appleCnt % studentCnt;
			
			--n;
		}
		
		sc.close();
		
		System.out.print(spareAppleCnt);
	}
	
}
