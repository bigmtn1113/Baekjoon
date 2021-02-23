import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		sc.close();
		
		String colorCode = "";
		
		if ((p <= 50) && (q <= 10)) {
			colorCode = "White";
		} else if (p > 50 && q > 10) {
			colorCode = "Red";
		} else {
			colorCode = "Yellow";
		}
		
		System.out.print(colorCode);
	}
	
}
