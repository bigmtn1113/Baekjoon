import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while (t > 0) {
			int d = sc.nextInt();
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			
			String result = "";
			
			if (n * s < d + n * p) {
				result = "do not parallelize";
			} else if(n * s > d + n * p) {
				result = "parallelize";
			} else {
				result = "does not matter";
			}
			
			System.out.println(result);
			
			--t;
		}
		
		sc.close();
	}
	
}
