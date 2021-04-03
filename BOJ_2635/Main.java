import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		ArrayList<Integer> list = new ArrayList<>();
		int maxListSize = 0;
		
		ArrayList<Integer> temp = new ArrayList<>();
		
		for (int i = 1; i <= n; ++i) {
			list.add(n);
			list.add(i);
			
			while (true) {
				int newNum = list.get(list.size() - 2) - list.get(list.size() - 1);
				
				if (newNum < 0) {
					break;
				}
				
				list.add(newNum);
			}
			
			if (list.size() > maxListSize) {
				maxListSize = list.size();
				temp = (ArrayList<Integer>) list.clone();
			}
			
			list.clear();
		}
		
		StringBuilder answer = new StringBuilder();
		
		answer.append(maxListSize + "\n");
		
		for (int i : temp) {
			answer.append(i + " ");
		}
		
		System.out.print(answer);
	}
	
}
