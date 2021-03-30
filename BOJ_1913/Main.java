import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] array = new int[n][n];
		
		int i = 0;
		int j = 0;
		
		int startNum = 0;
		int num = n * n;
		int temp = n;
		
		while (n > 1) {
			for (i = startNum; i < n; ++i) {
				array[i][j] = num--;
			}
			
			--i;
			
			for (j = startNum + 1; j < n; ++j) {
				array[i][j] = num--;
			}
			
			--j;
			
			for (i = n - 2; i >= startNum; --i) {
				array[i][j] = num--;
			}
			
			++i;
			
			for (j = n - 2; j > startNum; --j) {
				array[i][j] = num--;
			}
			
			++j;
			
			--n;
			++startNum;
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int a = 0; a < temp; ++a) {
			for (int b = 0; b < temp; ++b) {
				if (array[a][b] == m) {
					i = a + 1;
					j = b + 1;
				}
				
				answer.append(array[a][b] + " ");
			}
			
			answer.append("\n");
		}
		
		System.out.print(answer.append(i + " " + j));
	}
	
}
