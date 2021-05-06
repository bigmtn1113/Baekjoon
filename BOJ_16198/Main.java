import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static int answer = 0;
	
	public static void recursionFunc(LinkedList<Integer> energeBead, int energeSum) {
		if (energeBead.size() == 2) {
			answer = Math.max(answer, energeSum);
			return;
		}
		
		for (int i = 1; i < energeBead.size() - 1; ++i) {
			int num = energeBead.get(i);
			int energe = energeBead.get(i - 1) * energeBead.get(i + 1);
			
			energeBead.remove(i);
			
			recursionFunc(energeBead, energeSum + energe);
			
			energeBead.add(i, num);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		LinkedList<Integer> energeBead = new LinkedList<>();
		
		for (int i = 0; i < n; ++i) {
			energeBead.add(sc.nextInt());
		}
		
		sc.close();
		
		recursionFunc(energeBead, 0);
		
		System.out.print(answer);
	}

}
