import java.util.Scanner;

public class Main {
	
	public static int[] cup = { 0, 1, 0, 0 };
	
	public static void swap(int index1, int index2) {
		int temp = cup[index1];
		cup[index1] = cup[index2];
		cup[index2] = temp;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String order = sc.next();
		
		sc.close();
		
		for (int i = 0; i < order.length(); ++i) {
			switch (order.charAt(i)) {
			case 'A':
				swap(1, 2);
				break;
				
			case 'B':
				swap(2, 3);
				break;
				
			default:
				swap(1, 3);
				break;
			}
		}
		
		for (int i = 1; i <= 3; ++i) {
			if (cup[i] == 1) {
				System.out.print(i);
			}
		}
	}
	
}
