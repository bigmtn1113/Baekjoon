import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int l = sc.nextInt();
		
		sc.close();
		
		int cowCnt = (w / l) * (h / l);
		
		System.out.print((cowCnt <= n) ? cowCnt : n);
	}
	
}
