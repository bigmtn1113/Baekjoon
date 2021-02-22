import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		
		sc.close();
		
		int remain = 0;
		
		for (int i = 0; i < n.length(); ++i) {
			remain = (remain * 10 + (n.charAt(i) - '0')) % 20000303; 
		}
		
		System.out.print(remain);
	}
	
}
