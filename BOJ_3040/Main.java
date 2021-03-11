import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> hatOrCap = new ArrayList<>();
		
		int sum = -100;

		for (int i = 0; i < 9; ++i) {
			hatOrCap.add(sc.nextInt());
			
			sum += hatOrCap.get(i);
		}
		
		sc.close();
		
		label: for (int i = 0; i < 9; ++i) {
			for (int j = i + 1; j < 9; ++j) {
				if (hatOrCap.get(i) + hatOrCap.get(j) == sum) {
					hatOrCap.remove(j);
					hatOrCap.remove(i);
					
					break label;
				}
			}
		}
		
		for (int num : hatOrCap) {
			System.out.println(num);
		}
	}
	
}
