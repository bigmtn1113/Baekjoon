import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int scoreSum = sc.nextInt();
		int scoreDifference = sc.nextInt();
		
		sc.close();
		
		int team1 = (scoreSum + scoreDifference) / 2;
		int team2 = scoreSum - team1;
		boolean check = (scoreSum == (team1 + team2)) && (scoreDifference == (team1 - team2));
		
		System.out.print((check && (scoreSum >= scoreDifference)) ? team1 + " " + team2 : -1);
	}
	
}
