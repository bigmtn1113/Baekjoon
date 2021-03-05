import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String n = Integer.toBinaryString(sc.nextInt());
		
		sc.close();
		
		for (int i = 1; i < n.length(); ++i) {
			if (n.charAt(i) == '1') {
				System.out.print(0);
				System.exit(0);
			}
		}
		
		System.out.print(1);
	}
	
}
