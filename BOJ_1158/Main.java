import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt() - 1;
		
		sc.close();
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int i = 1; i <= n; ++i) {
			list.add(i);
		}
		
		int temp = k;
		StringBuilder answer = new StringBuilder("<");
		
		while (list.size() > 1) {
			answer.append(list.remove(temp)).append(", ");
			
			temp = (temp + k) % list.size();
		}
		
		answer.append(list.get(0)).append(">");
		
		System.out.print(answer);
	}
	
}
