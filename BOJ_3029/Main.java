import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String curTime = sc.next();
		String natriumThrowingTime = sc.next();
		
		sc.close();
		
		if (curTime.equals(natriumThrowingTime)) {
			System.out.print("24:00:00");
			System.exit(0);
		}
		
		int h = Integer.parseInt(natriumThrowingTime.split(":")[0]) - Integer.parseInt(curTime.split(":")[0]);
		int m = Integer.parseInt(natriumThrowingTime.split(":")[1]) - Integer.parseInt(curTime.split(":")[1]);
		int s = Integer.parseInt(natriumThrowingTime.split(":")[2]) - Integer.parseInt(curTime.split(":")[2]);
		
		if (s < 0) {
			s += 60;
			--m;
		}
		
		if (m < 0) {
			m += 60;
			--h;
		}
		
		if (h < 0) {
			h += 24;
		}
		
		System.out.format("%02d:%02d:%02d", h, m, s);
	}
	
}
