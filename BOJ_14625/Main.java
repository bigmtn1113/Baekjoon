import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int startH = sc.nextInt();
		int startM = sc.nextInt();
		int endH = sc.nextInt();
		int endM = sc.nextInt();
		
		int n = sc.nextInt();
		
		sc.close();
		
		int cnt = 0;
		
		while (true) {
			if ((startH / 10 == n) || (startH % 10 == n) || (startM / 10 == n) || (startM % 10 == n)) {
				++cnt;
			}
			
			if ((startH == endH) && (startM == endM)) {
				break;
			}
			
			++startM;
			
			if (startM > 59) {
				++startH;
				startM = 0;
			}
		}
		
		System.out.print(cnt);
	}
	
}
