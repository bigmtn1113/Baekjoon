import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.next().split(":");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		sc.close();
		
		int tempN = n;
		int tempM = m;
		
		if (tempN < tempM) {
			int temp = tempN;
			tempN = tempM;
			tempM = temp;
		}
		
		while (tempN % tempM != 0) {
			int temp = tempN;
			tempN = tempM;
			tempM = temp % tempN;
		}
		
		System.out.format("%d:%d", n / tempM, m / tempM);
	}

}
