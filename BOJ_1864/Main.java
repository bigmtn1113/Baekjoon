import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String octopusSign = "-\\(@?>&%/";
		
		while (true) {
			String octopusNum = sc.next();
			
			if (octopusNum.equals("#")) {
				break;
			}
			
			int result = 0;
			
			for (int i = 0; i < octopusNum.length(); ++i) {
				int octopusSignIndex = octopusSign.indexOf(octopusNum.charAt(i));
				
				if (octopusSignIndex == 8) {
					octopusSignIndex = -1;
				}
				
				result += octopusSignIndex * Math.pow(8, (octopusNum.length() - 1) - i);
			}
			
			System.out.println(result);
		}
		
		sc.close();
	}
	
}
