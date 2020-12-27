import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int n = sc.nextInt();
			
			if (n == 0) {
				sc.close();
				break;
			}
			
			List<Integer> array = new ArrayList<>();
			
			for (int i = 0; i < n; ++i) {
				array.add(sc.nextInt());
			}
			
			Collections.sort(array);
			
			String num1 = "";
			String num2 = "";
			
			for (int i = 0; i < n; ++i) {
				int firstMinNum = array.get(i);
				
				if (firstMinNum != 0) {
					int secondMinNum = array.get(i + 1);
					
					num1 += firstMinNum;
					num2 += secondMinNum;
					
					array.remove(i);
					array.remove(i);
					break;
				}
			}
			
			for (int i = 0; i < n - 2; ++i) {
				if (i % 2 == 0) {
					num1 += array.get(i);
				} else {
					num2 += array.get(i);
				}
			}
			
			int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
			System.out.println(sum);
		}
	}
	
}
