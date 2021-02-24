import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int ab = sc.nextInt();
		
		sc.close();
		
		int sum = 0;
		
		if (ab < 100) {
			sum = ab / 10 + ab % 10;
		} else if(ab < 110) {
			sum = 10 + ab % 100;
		} else {
			sum = ab / 100 + 10;
		}
		
		System.out.print(sum);
	}
	
}
