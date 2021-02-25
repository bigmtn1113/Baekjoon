import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int changyoungScore = 100;
		int sangdeokScore = 100;
		
		while (n > 0) {
			int changyoungNum = sc.nextInt();
			int sangdeokNum = sc.nextInt();
			
			if (changyoungNum < sangdeokNum) {
				changyoungScore -= sangdeokNum;
			} else if (changyoungNum > sangdeokNum) {
				sangdeokScore -= changyoungNum;
			}
			
			--n;
		}
		
		sc.close();
		
		System.out.print(changyoungScore + "\n" + sangdeokScore);
	}
	
}
