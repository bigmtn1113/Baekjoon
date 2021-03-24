import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> array = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			array.add(sc.nextInt());
		}
		
		sc.close();
		
		Collections.sort(array);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i : array) {
			sb.append(i).append("\n");
		}
		
		System.out.print(sb);
	}
	
}
