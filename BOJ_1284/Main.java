import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String n = sc.next();
			
			if (n.equals("0")) {
				break;
			}
			
			int whiteSpace = (n.length() - 1) + 1 + 1;
			
			for (int i = 0; i < n.length(); ++i) {
				char charNum = n.charAt(i);
				
				if (charNum == '0') {
					whiteSpace += 4;
				} else if (charNum == '1') {
					whiteSpace += 2;
				} else {
					whiteSpace += 3;
				}
			}
			
			System.out.println(whiteSpace);
		}
		
		sc.close();
	}
	
}
