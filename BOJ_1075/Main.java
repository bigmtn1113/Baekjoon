import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		int f = sc.nextInt();
		
		sc.close();
		
		int changedMinN = Integer.parseInt(n.substring(0, n.length() - 2) + "00");
		int changedMaxN = Integer.parseInt(n.substring(0, n.length() - 2) + "99");
		
		for (int i = changedMinN; i <= changedMaxN; ++i) {
			if (i % f == 0) {
				System.out.format("%02d", i % 100);
				break;
			}
		}
	}
	
}
