import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] array = new int[n + 1];
		
		for (int i = 1; i <= n; ++i) {
			array[i] = sc.nextInt();
		}
		
		sc.close();
		
		int[] resultArray = new int[n + 1];
		
		int cnt = 0;
		
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if ((cnt == array[i]) && (resultArray[j] == 0)) {
					resultArray[j] = i;
					cnt = 0;
					break;
				}
				
				if (resultArray[j] == 0) {
					++cnt;
				}
			}
		}
		
		for (int i = 1; i <= n; ++i) {
			System.out.print(resultArray[i] + " ");
		}
	}

}
