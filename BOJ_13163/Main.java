import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; ++i) {
			String[] nickname = sc.nextLine().split(" ");
			
			System.out.print("god");
			
			for (int j = 1; j < nickname.length; ++j) {
				System.out.print(nickname[j]);
			}
			
			System.out.println();
		}
		
		sc.close();
	}
	
}
