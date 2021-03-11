import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		sc.close();
		
		int min = Integer.parseInt(a.replaceAll("6", "5")) + Integer.parseInt(b.replaceAll("6", "5"));
		int max = Integer.parseInt(a.replaceAll("5", "6")) + Integer.parseInt(b.replaceAll("5", "6"));
		
		System.out.print(min + " " + max);
	}
	
}
