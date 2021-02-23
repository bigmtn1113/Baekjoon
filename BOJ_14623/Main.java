import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int b1 = Integer.parseInt(sc.next(), 2);
		int b2 = Integer.parseInt(sc.next(), 2);
		
		sc.close();
		
		System.out.print(Long.toBinaryString((long) b1 * b2));
	}
	
}
