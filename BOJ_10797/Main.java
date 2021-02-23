import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int day = sc.nextInt();		
		int[] carNum = new int[5];
		int cnt = 0;
		
		for (int i = 0; i < 5; ++i) {
			carNum[i] = sc.nextInt();
			
			if (carNum[i] == day) {
				++cnt;
			}
		}
		
		sc.close();
		
		System.out.print(cnt);
	}
	
}
