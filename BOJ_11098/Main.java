import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 0; i < n; ++i) {
			int p = sc.nextInt();
			
			int maxC = 0;
			String mostExpensivePlayer = "";
			
			for (int j = 0; j < p; ++j) {
				int c = sc.nextInt();
				String name = sc.next();
				
				if (c > maxC) {
					maxC = c;
					mostExpensivePlayer = name;
				}
			}

			System.out.println(mostExpensivePlayer);
		}
		
		sc.close();
	}
	
}
