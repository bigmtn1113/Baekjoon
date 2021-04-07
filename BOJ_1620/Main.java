import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		HashMap<String, Integer> map = new HashMap<>();
		String[] names = new String[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			String name = sc.next();
			
			map.put(name, i);
			names[i] = name;
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < m; ++i) {
			if (sc.hasNextInt()) {
				answer.append(names[sc.nextInt()]).append("\n");
			} else {
				answer.append(map.get(sc.next())).append("\n");
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
