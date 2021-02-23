import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] abcd = new int[4];
		
		for (int i = 0; i < 4; ++i) {
			abcd[i] = sc.nextInt();
		}
		
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		sc.close();
		
		Arrays.sort(abcd);
		
		System.out.print(abcd[1] + abcd[2] + abcd[3] + Math.max(e, f));
	}
	
}
