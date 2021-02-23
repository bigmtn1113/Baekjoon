import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int k = sc.nextInt();
		int h = sc.nextInt();
		
		sc.close();
		
		String result = "";
		
		if (s + k + h >= 100) {
			result = "OK";
		} else {
			int temp = Math.min(Math.min(s, k), h);
			
			if (temp == s) {
				result = "Soongsil";
			} else if (temp == k) {
				result = "Korea";
			} else{
				result = "Hanyang";
			}
		}
		
		System.out.print(result);
	}
	
}
