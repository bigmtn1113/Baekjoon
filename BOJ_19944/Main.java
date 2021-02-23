import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sc.close();
		
		String result = "";
		
		if (m == 1 || m == 2) {
			result = "NEWBIE!";
		} else if (m <= n){
			result = "OLDBIE!";
		} else {
			result = "TLE!";
		}
		
		System.out.print(result);
	}
	
}
