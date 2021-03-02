import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		long aAddB = (long) a + b;
		long numCnt = (b > a) ? (long) b - a + 1 : (long) a - b + 1;
		long sum = (numCnt % 2 == 0) ? aAddB * (numCnt / 2) : aAddB * (numCnt / 2) + aAddB / 2; 
		
		System.out.print(sum);
	}
	
}
