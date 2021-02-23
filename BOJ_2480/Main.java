import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int diceNum1 = sc.nextInt();
		int diceNum2 = sc.nextInt();
		int diceNum3 = sc.nextInt();
		
		sc.close();
		
		int reward = 0;
		
		if ((diceNum1 == diceNum2) && (diceNum2 == diceNum3)) {
			reward = 10000 + diceNum1 * 1000;
		} else if ((diceNum1 != diceNum2) && (diceNum2 != diceNum3) && (diceNum1 != diceNum3)) {
			reward = Math.max(Math.max(diceNum1, diceNum2),diceNum3) * 100;
		} else {
			if ((diceNum1 == diceNum2) || (diceNum1 == diceNum3)) {
				reward = 1000 + diceNum1 * 100;
			} else if (diceNum2 == diceNum3) {
				reward = 1000 + diceNum2 * 100;
			}
		}
		
		System.out.print(reward);
	}
	
}
