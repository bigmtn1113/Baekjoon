import java.util.Scanner;

public class Main {
	public static int maxNum = -1000000000;
	public static int minNum = 1000000000;
	
	public static void recursionFunc(int[] a, int index, int plus, int minus, int multiplication, int division, int sum) {
		if (index == a.length - 1) {
			maxNum = Math.max(maxNum, sum);
			minNum = Math.min(minNum, sum);
			
			return;
		}
		
		if (plus > 0) {
			recursionFunc(a, index + 1, plus - 1, minus, multiplication, division, sum + a[index + 1]);
		}
		
		if (minus > 0) {
			recursionFunc(a, index + 1, plus, minus - 1, multiplication, division, sum - a[index + 1]);
		}
		
		if (multiplication > 0) {
			recursionFunc(a, index + 1, plus, minus, multiplication - 1, division, sum * a[index + 1]);
		}
		
		if (division > 0) {
			recursionFunc(a, index + 1, plus, minus, multiplication, division - 1, sum / a[index + 1]);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		for (int i = 0; i < n; ++i) {
			a[i] = sc.nextInt();
		}
		
		int[] operatorArray = new int[4];
		
		for (int i = 0; i < 4; ++i) {
			operatorArray[i] = sc.nextInt();
		}
		
		sc.close();
		
		recursionFunc(a, 0, operatorArray[0], operatorArray[1], operatorArray[2], operatorArray[3], a[0]);
		
		System.out.format("%d\n%d", maxNum, minNum);
	}

}
