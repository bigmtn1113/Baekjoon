import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int studentCnt = sc.nextInt();
		
		ArrayList<Integer> order = new ArrayList<>();
		
		for (int i = 1; i <= studentCnt; ++i) {
			int drawNum = sc.nextInt();
			
			order.add(order.size() - drawNum, i);
		}
		
		sc.close();
		
		for (int num : order) {
			System.out.print(num + " ");
		}
	}
	
}
