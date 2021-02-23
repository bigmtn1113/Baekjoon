import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[][] date = new int[2][3];
		
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 3; ++j) {
				date[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		int yearAge = date[1][0] - date[0][0];
		int internationalAge = yearAge;
		
		if (yearAge > 0) {
			if (date[0][1] > date[1][1]) {
				--internationalAge;
			} else if ((date[0][1] == date[1][1]) && (date[0][2] > date[1][2])) {
				--internationalAge;
			}
		}
		
		System.out.print(internationalAge + " " + (yearAge + 1) + " " + yearAge);
	}
	
}
