import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int e = sc.nextInt();
		int f = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		
		int emptyBottles = e + f;
		int cnt = 0;
		
		while (emptyBottles / c > 0) {
			cnt += emptyBottles / c;
			emptyBottles = emptyBottles / c + emptyBottles % c;
		}
		
		System.out.print(cnt);
	}
	
}
