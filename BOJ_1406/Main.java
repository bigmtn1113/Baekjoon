import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int m = sc.nextInt();
		
		LinkedList<Character> list = new LinkedList<>();
		
		for (int i = 0; i < input.length(); ++i) {
			list.add(input.charAt(i));
		}
		
		ListIterator<Character> listIter = list.listIterator();
		
		while (listIter.hasNext()) {
			listIter.next();
		}
		
		for (int i = 0; i < m; ++i) {
			String order = sc.next();
			
			switch (order) {
			case "L":
				if (listIter.hasPrevious()) {
					listIter.previous();
				}
				break;
				
			case "D":
				if (listIter.hasNext()) {
					listIter.next();
				}
				break;
				
			case "B":
				if (listIter.hasPrevious()) {
					listIter.previous();
					listIter.remove();
				}
				break;

			default:
				char c = sc.next().charAt(0);
				
				listIter.add(c);
				break;
			}
		}
		
		sc.close();
		
		StringBuilder answer = new StringBuilder();
		
		for (char c : list) {
			answer.append(c);
		}
		
		System.out.print(answer);
	}

}
