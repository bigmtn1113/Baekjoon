import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		for (int i = n; i >= 4; --i) {
			boolean check = false;
			int temp = i;
			
			while ((temp % 10 == 4) || (temp % 10 == 7)) {
				if ((temp == 4) || (temp == 7)) {
					check = true;
					break;
				}
				
				temp /= 10;
			}
			
			if (check) {
				System.out.print(i);
				break;
			}
		}
	}
	
}
