import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
		
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		
		long proctorCnt = 0;
		
		for (int ai : a) {
			if (ai <= b) {
				++proctorCnt;
				continue;
			}
			
			++proctorCnt;
			ai -= b;
			
			if (ai <= c) {
				++proctorCnt;
				continue;
			}
			
			proctorCnt += (ai % c == 0) ? ai / c : ai / c + 1;
		}
		
		System.out.print(proctorCnt);
	}
	
}
