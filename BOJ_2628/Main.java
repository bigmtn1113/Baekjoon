import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int n = sc.nextInt();
		
		ArrayList<Integer> row = new ArrayList<>();
		ArrayList<Integer> col = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			int rc = sc.nextInt();
			int num = sc.nextInt();
			
			if (rc == 0) {
				row.add(num);
			} else {
				col.add(num);
			}
		}
		
		sc.close();
		
		Collections.sort(row);
		Collections.sort(col);
		
		row.add(h);
		col.add(w);
		
		int maxRow = row.get(0);
		int maxCol = col.get(0);
		
		for (int i = 1; i < row.size(); ++i) {
			maxRow = Math.max(maxRow, row.get(i) - row.get(i - 1));
		}
		
		for (int i = 1; i < col.size(); ++i) {
			maxCol = Math.max(maxCol, col.get(i) - col.get(i - 1));
		}
		
		System.out.print(maxRow * maxCol);
	}
	
}
