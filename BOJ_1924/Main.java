import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		sc.close();
		
		int[] monthStartDays = new int[13];
		monthStartDays[1] = 1;
		
		for (int i = 2; i < 13; ++i) {
			switch (i - 1) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
				monthStartDays[i] = (monthStartDays[i - 1] + 31) % 7;
				break;
				
			case 4:
			case 6:
			case 9:
			case 11:
				monthStartDays[i] = (monthStartDays[i - 1] + 30) % 7;
				break;

			default:
				monthStartDays[i] = (monthStartDays[i - 1] + 28) % 7;
				break;
			}
			
			if (monthStartDays[i] == 0) {
				monthStartDays[i] = 7;
			}
		}
		
		String[] month = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		System.out.print(month[(monthStartDays[x] + y - 1) % 7]);
	}
	
}
