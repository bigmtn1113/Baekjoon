import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		sc.close();
		
		ArrayList<Integer> cards = new ArrayList<>();
		
		for (int i = 1; i <= n; ++i) {
			cards.add(i);
		}
		
		for (int i = 0; i < n; ++i) {
			System.out.print(cards.remove(0) + " ");
			
			if (!cards.isEmpty()) {
				cards.add(cards.remove(0));
			}
		}
	}
	
}
