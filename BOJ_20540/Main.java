import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String MBTI = sc.next();
		
		for (int i = 0; i < 4; ++i) {
			char result = ' ';
			
			switch (MBTI.charAt(i)) {
			case 'E':
				result = 'I';
				break;

			case 'I':
				result = 'E';
				break;

			case 'S':
				result = 'N';
				break;

			case 'N':
				result = 'S';
				break;

			case 'T':
				result = 'F';
				break;

			case 'F':
				result = 'T';
				break;

			case 'J':
				result = 'P';
				break;

			default:
				result = 'J';
				break;
			}
			
			System.out.print(result);
		}
		
		sc.close();
	}
	
}
