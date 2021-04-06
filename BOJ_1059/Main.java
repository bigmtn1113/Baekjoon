import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int l = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < l; ++i) {
			list.add(sc.nextInt());
		}
		
		int n = sc.nextInt();
		
		sc.close();
		
		if (list.contains(n)) {
			System.out.print(0);
			System.exit(0);
		}
		
		Collections.sort(list);
		
		int a = 0;
		int b = 0;
		
		for (int i = 1; i < l; ++i) {
			if ((list.get(i - 1) < n) && (n < list.get(i))) {
				a = list.get(i - 1);
				b = list.get(i);
			}
		}
		
		if ((a == 0) && (b == 0)) {
			b = list.get(0);
		}
		
		System.out.print((n - a) * (b - n) - 1);
	}
	
}
