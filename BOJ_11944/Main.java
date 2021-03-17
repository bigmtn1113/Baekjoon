import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		sc.close();
		
		String nToStr = Integer.toString(n);
		
		if (nToStr.length() * n > m) {
			int cnt = 0;
			
			while (cnt < m) {
				for (int i = 0; i < nToStr.length(); ++i) {
					if (cnt == m) {
						break;
					}

					System.out.print(nToStr.charAt(i));
					++cnt;
				}
			}
		} else {
			for (int i = 0; i < n; ++i) {
				System.out.print(n);
			}
		}
	}
	
}
