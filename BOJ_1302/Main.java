import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		String[] books = new String[n];
		
		for (int i = 0; i < n; ++i) {
			books[i] = sc.next();
		}
		
		sc.close();
		
		Arrays.sort(books);
		
		int cnt = 1;
		int maxCnt = 1;
		
		String answer = books[0];
		int answerIndex = 0;
		
		for (int i = 0; i < n; ++i) {
			String temp = books[i];
			
			for (int j = i + 1; j < n; ++j) {
				if (books[j].equals(temp)) {
					++cnt;
					answerIndex = j;
				} else {
					if (cnt > maxCnt) {
						maxCnt = cnt;
						answer = temp;
					}
					
					cnt = 1;
					break;
				}
				
				i = j;
			}
		}
		
		if (cnt > maxCnt) {
			answer = books[answerIndex];
		}
		
		System.out.print(answer);
	}

}
