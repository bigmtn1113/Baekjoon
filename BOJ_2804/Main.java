import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		
		sc.close();
		
		int aIndex = 0;
		int bIndex = 0;
		
		label: for (int i = 0; i < a.length(); ++i) {
			char c = a.charAt(i);
			
			for (int j = 0; j < b.length(); ++j) {
				if (c == b.charAt(j)) {
					aIndex = i;
					bIndex = j;
					
					break label;
				}
			}
		}
		
		for (int i = 0; i < b.length(); ++i) {
			if (i != bIndex) {
				for (int j = 0; j < a.length(); ++j) {
					System.out.print((j != aIndex) ? "." : b.charAt(i));
				}
				
				System.out.println();
			} else {
				System.out.println(a);
			}
		}
	}
	
}
