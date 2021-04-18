import java.util.Scanner;

public class Main {
	public static boolean[] primeNumArray = new boolean[1000];
	public static int[] result = new int[3];
	public static boolean find = false;
	public static StringBuilder answer = new StringBuilder();
	
	public static boolean check(int k, int cnt, int sum) {
		if (cnt == 3) {
			if ((sum == k) && !find) {
				find = true;
				
				for (int i = 0; i < 3; ++i) {
					answer.append(result[i]).append(" ");
				}
				
				answer.append("\n");
			}
			
			return find;
		}
		
		for (int i = 2; i < k; ++i) {
			if (!primeNumArray[i]) {	// 소수일 때만
				result[cnt] = i;	// 소수 저장
				
				if (check(k, cnt + 1, sum + i)) {
					return find;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 소수 구하기
		for (int i = 2; i * i < 1000; ++i) {
			if (primeNumArray[i]) {
				continue;
			}
			
			for (int j = i + i; j < 1000; j += i) {
				if (!primeNumArray[j]) {
					primeNumArray[j] = true;
				}
			}
		}
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; ++i) {
			int k = sc.nextInt();
			
			find = false;
			
			if (!check(k, 0, 0)) {	// 답이 불가능 하면 0
				answer.append("0").append("\n");
			}
		}
		
		sc.close();
		
		System.out.print(answer);
	}

}
