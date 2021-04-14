import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			String l = sc.next();
			
			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> listIter = list.listIterator();
			
			for (int j = 0; j < l.length(); ++j) {
				char c = l.charAt(j);
				
				switch (c) {
				case '<':
					if (listIter.hasPrevious()) {
						listIter.previous();
					}
					break;
					
				case '>':
					if (listIter.hasNext()) {
						listIter.next();
					}
					break;
					
				case '-':
					if (listIter.hasPrevious()) {
						listIter.previous();
						listIter.remove();
					}
					break;

				default:
					listIter.add(c);
					break;
				}
			}
			
			for (char c : list) {
				answer.append(c);
			}
			
			answer.append("\n");
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
