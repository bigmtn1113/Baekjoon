import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int ySum = 0;
		int mSum = 0;
		
		while (n > 0) {
			int time = sc.nextInt();
			
			ySum += (time / 30 + 1) * 10;
			mSum += (time / 60 + 1) * 15;
			
			--n;
		}
		
		sc.close();
		
		String result = "";
		
		if (ySum < mSum) {
			result = "Y " + ySum;
		} else if (ySum == mSum) {
			result = "Y M " + ySum;
		} else {
			result = "M " + mSum;
		}
		
		System.out.print(result);
	}
	
}
