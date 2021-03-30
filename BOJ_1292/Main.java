import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt() - 1;
		int b = sc.nextInt();
		
		sc.close();
		
		int[] array = new int[1000];
		
		int num = 1;
		int index = 0;
		
		label: while (true) {
			for (int i = 0; i < num; ++i) {
				array[index++] = num;
				
				if (index > 999) {
					break label;
				}
			}
			
			++num;
		}
		
		int sum = 0;
		
		for (int i = a; i < b; ++i) {
			sum += array[i];
		}
		
		System.out.print(sum);
	}
	
}
