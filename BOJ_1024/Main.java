import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		
		sc.close();
		
		StringBuilder answer = new StringBuilder();
		
		boolean canFind = false;
		
		for (int i = l; i <= 100; ++i) {
			int ix = n - i * (i - 1) / 2;
			
			if ((ix % i == 0) && (ix / i >= 0)) {
				int x = ix / i;
				
				for (int j = 0; j < i; ++j) {
					answer.append(j + x).append(" ");
				}
				
				canFind = true;
				break;
			}
		}
		
		System.out.print((canFind) ? answer : -1);
	}

}
