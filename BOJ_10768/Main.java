import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		sc.close();
		
		String result = "";
		
		if (month < 2) {
			result = "Before";
		} else if (month == 2) {
			if (day < 18) {
				result = "Before";
			} else if (day == 18) {
				result = "Special";
			} else {
				result = "After";
			}
		} else {
			result = "After";
		}
		
		System.out.print(result);
	}
	
}
