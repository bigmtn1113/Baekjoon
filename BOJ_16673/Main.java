import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int c = sc.nextInt();
		int k = sc.nextInt();
		int p = sc.nextInt();
		
		sc.close();
		
		int wineCnt = 0;
		
		for (int i = 1; i <= c; ++i) {
			wineCnt += k * i + p * i * i;
		}
		
		System.out.print(wineCnt);
	}
	
}
