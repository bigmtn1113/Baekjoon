import java.util.Scanner;

public class Main {
	
	public static void reverseOrder(StringBuilder answer, StringBuilder reverseWord) {
		for (int i = reverseWord.length() - 1; i >= 0; --i) {
			answer.append(reverseWord.charAt(i));
		}
		
		reverseWord.setLength(0);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		sc.close();
		
		StringBuilder answer = new StringBuilder();
		StringBuilder reverseWord = new StringBuilder();
		
		boolean tagCheck = false;
		
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			
			switch (c) {
			case '<':
				if (reverseWord.length() > 0) {
					reverseOrder(answer, reverseWord);
				}
				
				answer.append("<");
				tagCheck = true;
				break;
				
			case '>':
				answer.append(">");
				tagCheck = false;
				break;
				
			default:
				if (tagCheck) {
					answer.append(c);
					break;
				}
				
				if (c == ' ') {
					reverseOrder(answer, reverseWord);
					answer.append(' ');
				} else {
					reverseWord.append(c);
				}
				break;
			}
		}
		
		if (reverseWord.length() > 0) {
			reverseOrder(answer, reverseWord);
		}
		
		System.out.print(answer);
	}

}
