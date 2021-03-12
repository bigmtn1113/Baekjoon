import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] a = new int[10];
		int[] cnt = new int[2];
		
		for (int i = 0 ; i < 10; ++i) {
			a[i] = sc.nextInt();
		}
		
		for (int i = 0 ; i < 10; ++i) {
			int b = sc.nextInt();
			
			if (a[i] > b) {
				++cnt[0];
			} else if (a[i] < b) {
				++cnt[1];
			}
		}
		
		sc.close();
		
		if (cnt[0] > cnt[1]) {
			System.out.print("A");
		} else if (cnt[0] == cnt[1]) {
			System.out.print("D");
		} else {
			System.out.print("B");
		}
	}
	
}
