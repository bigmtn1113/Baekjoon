import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int l = sc.nextInt();
		int d = sc.nextInt();
		
		sc.close();
		
		int quietTimeStart = 0;
		int quietTimeEnd = 0;
		
		for (int i = 0; i < n; ++i) {
			quietTimeStart = quietTimeEnd + l;
			quietTimeEnd = quietTimeStart + 5;
			
			for (int j = quietTimeStart; j < quietTimeEnd; ++j) {
				if (j % d == 0) {
					System.out.print(j);
					System.exit(0);
				}
			}
		}
		
		int albumEndTime = (n * l) + (n - 1) * 5;
		
		while (true) {
			if (albumEndTime % d == 0) {
				System.out.print(albumEndTime);
				break;
			}
			
			++albumEndTime;
		}
	}
	
}
