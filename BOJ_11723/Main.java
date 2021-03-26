import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// 비트마스크 풀이
		Scanner sc = new Scanner(System.in);
		
		StringBuilder answer = new StringBuilder();
		
		int m = sc.nextInt();
		
		int bitset = 0;
		
		for (int i = 0; i < m; ++i) {
			String command = sc.next();
			
			switch (command) {
			case "add":
				bitset |= (1 << sc.nextInt() - 1);
				break;
				
			case "remove":
				bitset &= ~(1 << sc.nextInt() - 1);
				break;
				
			case "check":
				answer.append((bitset & (1 << sc.nextInt() - 1)) != 0 ? "1\n" : "0\n");
				break;
				
			case "toggle":
				bitset ^= (1 << sc.nextInt() - 1);
				break;
				
			case "all":
				bitset |= ~(0);
				break;

			default:
				bitset &= 0;
				break;
			}
		}
		
		sc.close();
		
		System.out.print(answer);
    
		/* ArrayList 풀이
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		
		for (int i = 1; i < 21; ++i) {
			list.add(i);
		}
		
		StringBuilder answer = new StringBuilder();
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; ++i) {
			String command = sc.next();
			
			switch (command) {
			case "add":
				s.add(sc.nextInt());
				break;
				
			case "remove":
				s.remove((Integer) sc.nextInt());
				break;
				
			case "check":
				if (s.contains(sc.nextInt())) {
					answer.append(1).append("\n");
				} else {
					answer.append(0).append("\n");
				}
				break;
				
			case "toggle":
				int x = sc.nextInt();
				
				if (s.contains(x)) {
					s.remove((Integer) x);
				} else {
					s.add(x);
				}
				break;
				
			case "all":
				s = list;
				break;

			default:
				s.clear();
				break;
			}
		}
		
		sc.close();
		
		System.out.print(answer);
		*/
	}
	
}
