import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		int[] status = new int[8];
		
		for (int i = 0; i < t; ++i) {
			for (int j = 0; j < 8; ++j) {
				status[j] = sc.nextInt();
			}
			
			int hp = (status[0] + status[4] > 1) ? status[0] + status[4] : 1;
			int mp = (status[1] + status[5] > 1) ? status[1] + status[5] : 1;
			int damage = (status[2] + status[6] > 0) ? status[2] + status[6] : 0;
			int defense = status[3] + status[7];
			
			int powerLevel = hp + 5 * mp + 2 * damage + 2 * defense;
			
			System.out.println(powerLevel);
		}
		
		sc.close();
	}
	
}
