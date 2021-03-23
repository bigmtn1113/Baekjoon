import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String[] input = sc.nextLine().split(" ");
			
			if (input[0].equals("-1")) {
				break;
			}
			
			int[] strInputToIntArray = new int[input.length - 1];
			boolean[] array = new boolean[100];
			
			for (int i = 0; i < strInputToIntArray.length; ++i) {
				strInputToIntArray[i] = Integer.parseInt(input[i]);
				array[strInputToIntArray[i]] = true;
			}
			
			int cnt = 0;
			
			for (int i : strInputToIntArray) {
				if ((i % 2 == 0) && (array[i / 2])) {
					++cnt;
				}
			}
			
			System.out.println(cnt);
		}
		
		sc.close();
	}
	
}
