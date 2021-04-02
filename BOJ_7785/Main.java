import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<String> set = new HashSet<>();
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			String name = sc.next();
			String enterOrLeave = sc.next();
			
			if (enterOrLeave.equals("enter")) {
				set.add(name);
			} else {
				set.remove(name);
			}
		}
		
		sc.close();
		
		Object[] setToArray = set.toArray();
		
		Arrays.sort(setToArray, Collections.reverseOrder());
		
		StringBuilder answer = new StringBuilder();
		
		for (Object o : setToArray) {
			answer.append(o + "\n");
		}
		
		System.out.print(answer);
	}
	
}
