import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
    // TreeSet<Integer> set = new TreeSet<>();
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < a; ++i) {
			set.add(sc.nextInt());
		}
		
		int cnt = 0;
		
		for (int i = 0; i < b; ++i) {
			if (set.contains(sc.nextInt())) {
				++cnt;
			}
		}
		
		sc.close();
		
		System.out.print(a - cnt + b - cnt);
	}

}
