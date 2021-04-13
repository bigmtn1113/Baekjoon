import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] a = new int[n + 1];
		
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
		
		sc.close();
		
		int left = 0;
		int right = 0;
		
		int sum = a[0];
		
		int answer = 0;
		
		while ((left <= right) && (right < n)) {
			if (sum == m) {
				++answer;
				
				sum += a[++right];
			} else if (sum < m) {
				sum += a[++right];
			} else {
				sum -= a[left++];
				
				if (left > right) {
					sum = a[left];
					right = left;
				}
			}
		}
		
		System.out.print(answer);
	}

}
