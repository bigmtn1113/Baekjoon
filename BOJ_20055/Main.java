import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[2 * n];
		
		for (int i = 0; i < a.length; ++i) {
			a[i] = sc.nextInt();
		}
		
		sc.close();
		
		// 벨트 위에 있는 로봇 위치 저장
		ArrayList<Integer> robotLocationList = new ArrayList<>();
		
		int answer = 0;
		
		while (k > 0) {
			++answer;
			
			// 회전
			int lastA = a[a.length - 1];
			
			for (int i = a.length - 1; i > 0; --i) {
				a[i] = a[i - 1];
			}
			
			a[0] = lastA;
			
			for (int i = 0; i < robotLocationList.size(); ++i) {
				robotLocationList.set(i, robotLocationList.get(i) + 1);
			}
			// ------------------------------------------
			
			// 로봇이 내리는 위치 도달
			if (!robotLocationList.isEmpty() && (robotLocationList.get(0) == n - 1)) {
				robotLocationList.remove(0);
			}
			
			// 이동
			for (int i = 0; i < robotLocationList.size(); ++i) {
				// 이동할 칸의 내구도가 0 이상이면
				if (a[robotLocationList.get(i) + 1] > 0) {
					// 이동할 칸에 로봇이 없으면
					if ((i == 0)
							|| ((i > 0) && (robotLocationList.get(i) + 1 != robotLocationList.get(i - 1)))) {
						robotLocationList.set(i, robotLocationList.get(i) + 1);
						--a[robotLocationList.get(i)];
						
						if (a[robotLocationList.get(i)] == 0) {
							--k;
						}
					}
				}
			}
			// ------------------------------------------
			
			// 로봇이 내리는 위치 도달
			if (!robotLocationList.isEmpty() && (robotLocationList.get(0) == n - 1)) {
				robotLocationList.remove(0);
			}
			
			// 로봇을 올릴 수 있으면
			if (a[0] > 0) {
				robotLocationList.add(0);
				--a[0];
				
				if (a[0] == 0) {
					--k;
				}
			}
		}
		
		System.out.print(answer);
	}

}
