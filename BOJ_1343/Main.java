import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String board = sc.next();
		
		sc.close();
		
		board = board.replaceAll("XXXX", "AAAA");
		board = board.replaceAll("XX", "BB");
		
		System.out.print((board.contains("X")) ? -1 : board);
	}
	
}
