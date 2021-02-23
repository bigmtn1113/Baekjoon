import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		int fingerNum = 0;
		
		if (n % 8 == 1) {
			fingerNum = 1;
		} else if ((n % 8 == 2) || (n % 8 == 0)) {
			fingerNum = 2;
		} else if ((n % 8 == 3) || (n % 8 == 7)) {
			fingerNum = 3;
		} else if ((n % 8 == 4) || (n % 8 == 6)) {
			fingerNum = 4;
		} else {
			fingerNum = 5;
		}
		
		System.out.print(fingerNum);
	}
	
}
