import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String x = sc.next();
		String y = sc.next();
		
		sc.close();
		
		String reverseX = "";
		String reverseY = "";
		
		for (int i = x.length() - 1; i >= 0; --i) {
			reverseX += x.charAt(i);
		}
		
		for (int i = y.length() - 1; i >= 0; --i) {
			reverseY += y.charAt(i);
		}
		
		String xy = Integer.parseInt(reverseX) + Integer.parseInt(reverseY) + "";
		String reverseXY = "";
		
		for (int i = xy.length() - 1; i >= 0; --i) {
			reverseXY += xy.charAt(i);
		}
		
		System.out.print(Integer.parseInt(reverseXY));
	}
	
}
