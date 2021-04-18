import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		TreeSet<String> set = new TreeSet<>();
		
		for (int i = 0; i < n; ++i) {
			set.add(sc.next());
		}
		
		int answer = 0;
		
		for (int i = 0; i < m; ++i) {
			if (set.contains(sc.next())) {
				++answer;
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
