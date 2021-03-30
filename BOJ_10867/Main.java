import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < n; ++i) {
			set.add(sc.nextInt());
		}
		
		sc.close();
		
		Object[] setToArray = set.toArray();
		
		Arrays.sort(setToArray);
		
		StringBuilder answer = new StringBuilder();
		
		for (Object o : setToArray) {
			answer.append(o + " ");
		}
		
		System.out.print(answer);
	}
	
}
