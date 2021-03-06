import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> height = new ArrayList<>();
		
		int sum = 0;
		
		for (int i = 0; i < 9; ++i) {
			height.add(sc.nextInt());
			
			sum += height.get(i);
		}
		
		sc.close();
		
		label: for (int i = 0; i < 9; ++i) {
			int tempSum = sum - height.get(i);
			
			for (int j = i + 1; j < 9; ++j) {
				if ((tempSum - height.get(j)) == 100) {
					height.remove(j);
					height.remove(i);
					break label;
				}
			}
		}
		
		Collections.sort(height);
		
		for (Integer result : height) {
			System.out.println(result);
		}
	}
	
}
