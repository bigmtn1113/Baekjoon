import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] nums = new int[1000];
		int sum = 0;
		
		for (int i = 0; i < 10; ++i) {
			int n = sc.nextInt();
			
			sum += n;
			++nums[n];
		}
		
		sc.close();
		
		int maxCnt = 0;
		int mode = 0;
		
		for (int i = 0; i < 1000; ++i) {
			if (nums[i] > maxCnt) {
				maxCnt = nums[i];
				mode = i;
			}
		}
		
		System.out.print(sum / 10 + "\n" + mode);
	}
	
}
