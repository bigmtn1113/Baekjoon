import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		sc.close();
		
		String[] kda = input.split("/");
		int k = Integer.parseInt(kda[0]);
		int d = Integer.parseInt(kda[1]);
		int a = Integer.parseInt(kda[2]);
		
		String level = "";
		
		if (((k + a) < d) || d == 0) {
			level = "hasu";
		} else {
			level = "gosu";
		}
		
		System.out.print(level);
	}
	
}
