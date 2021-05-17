import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] diceNums = new int[7];
		
		for (int i = 1; i < 7; ++i) {
			diceNums[i] = sc.nextInt();
		}
		
		sc.close();
		
		long answer = 0;
		
		if (n == 1) {
			Arrays.sort(diceNums, 1, 7);
			
			for (int i = 1; i < 6; ++i) {
				answer += diceNums[i];
			}
		} else {
			// 주사위가 될 수 있는 경우
			String[] dices = {"123", "124", "135", "145", "236", "246", "356", "456"};
			
			int minSum = 151;
			String minDice = "";
			
			// 합이 가장 작은 주사위 조합 찾기
			for (String dice : dices) {
				int sum = 0;
				
				for (int i = 0; i < 3; ++i) {
					sum += diceNums[dice.charAt(i) - '0'];
				}
				
				if (sum < minSum) {
					minSum = sum;
					minDice = dice;
				}
			}
			
			int[] nums = new int[3];
			
			for (int i = 0; i < 3; ++i) {
				nums[i] = diceNums[minDice.charAt(i) - '0'];
			}
			
			Arrays.sort(nums);
			
			// 맨 윗 층 빼고 나머지 층 계산 
			int layerNumsSum = ((nums[0] + nums[1]) * 4) + (nums[0] * (n - 2) * 4);
			
			for (int i = 0; i < n - 1; ++i) {
				answer += layerNumsSum;
			}
			
			// 맨 윗 층 계산
			long topLayerNumsSum = ((nums[0] + nums[1] + nums[2]) * 4)
					+ ((nums[0] + nums[1]) * (n - 2) * 4)
					+ ((long) nums[0] * (n - 2) * (n - 2));
			
			answer += topLayerNumsSum;
		}
		
		System.out.print(answer);
	}

}
