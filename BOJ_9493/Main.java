import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int m = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if ((m == 0) && (a == 0) && (b == 0)) {
				break;
			}
			
			double train = (double) m / a;
			double airplain = (double) m / b;
			double result = Math.round((train - airplain) * 3600);
			
			String h = Integer.toString((int) (result / 3600));
			String mm = Integer.toString((int) (result / 60 % 60));
			String ss = Integer.toString((int) (result % 60));
			
			if (mm.length() == 1) {
				mm = "0" + mm;
			}
			
			if (ss.length() == 1) {
				ss = "0" + ss;
			}
			
			System.out.println(h + ":" + mm + ":" + ss);
		}
		
		sc.close();
	}
	
}
