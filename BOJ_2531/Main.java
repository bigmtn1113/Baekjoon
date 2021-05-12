import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int d = sc.nextInt();		// 사용 하지 않아도 되는 변수...
		int k = sc.nextInt();
		int c = sc.nextInt();
		
		int[] sushiArray = new int[n + k - 1];
		
		for (int i = 0; i < n; ++i) {
			sushiArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		for (int i = n; i < sushiArray.length; ++i) {
			sushiArray[i] = sushiArray[i - n];
		}
		
		HashSet<Integer> selectedTypesOfSushi = new HashSet<>();
		
		int answer = 0;
		
		for (int i = 0; i <= n - 1; ++i) {
			selectedTypesOfSushi.clear();
			
			for (int j = i; j < i + k; ++j) {
				selectedTypesOfSushi.add(sushiArray[j]);
			}
			
			selectedTypesOfSushi.add(c);
			
			answer = Math.max(answer, selectedTypesOfSushi.size());
			
			if (answer == k + 1) {
				break;
			}
		}
		
		System.out.print(answer);
	}

}
