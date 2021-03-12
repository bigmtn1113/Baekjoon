import java.util.Scanner;

public class Main {
	
	public static int[] cards = new int[20];
	
	public static void swap(int index1, int index2) {
		int temp = cards[index1];
		cards[index1] = cards[index2];
		cards[index2] = temp;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 20; ++i) {
			cards[i] = i + 1;
		}
		
		for (int i = 0; i < 10; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for (int j = a - 1, k = b - 1; j < k; ++j, --k) {
				swap(j, k);
			}
		}
		
		sc.close();
		
		for (int card : cards) {
			System.out.print(card + " ");
		}
	}
	
}
