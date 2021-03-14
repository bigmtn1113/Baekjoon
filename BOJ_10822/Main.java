import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String[] s = sc.next().split(",");
		
		sc.close();
		
		int sum = 0;
		
		for (int i = 0; i < s.length; ++i) {
			sum += Integer.parseInt(s[i]);
		}
		
		System.out.print(sum);
	}
	
}
