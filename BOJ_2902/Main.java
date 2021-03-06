import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.next().split("-");
		
		sc.close();
		
		for (String result : input) {
			System.out.print(result.charAt(0));
		}
	}
	
}
