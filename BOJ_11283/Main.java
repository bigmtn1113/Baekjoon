import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String id = sc.next();
		
		sc.close();
		
		System.out.print(id.charAt(0) - 44031);
	}
	
}
