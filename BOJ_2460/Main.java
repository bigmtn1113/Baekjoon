import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int peopleCnt = 0;
		int peopleMaxCnt = 0;
		
		for (int i = 0; i < 10; ++i) {
			int getOff = sc.nextInt();
			int getOn = sc.nextInt();
			
			peopleCnt += getOn - getOff;
			peopleMaxCnt = Math.max(peopleMaxCnt, peopleCnt);
		}
		
		sc.close();
		
		System.out.print(peopleMaxCnt);
	}
	
}
