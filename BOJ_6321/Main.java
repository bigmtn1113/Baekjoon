import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; ++i) {
			String computerName = sc.next();
			
			System.out.println("String #" + i);
			
			for (int j = 0; j < computerName.length(); ++j) {
				char c = computerName.charAt(j);
				
				System.out.print((c != 'Z') ? (char) (c + 1) : 'A');
			}
			
			
			System.out.println();
			System.out.println();
		}
		
		sc.close();
	}
	
}
