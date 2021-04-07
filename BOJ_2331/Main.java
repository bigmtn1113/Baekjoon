import java.util.Scanner;

public class Main {
	public static int[] nums = new int[400000];
	public static boolean[] visited = new boolean[400000];
	
	public static int check(int v, int repeatStartNum, int cnt) {
		if (nums[v] == repeatStartNum) {
			return cnt;
		}
		
		return (visited[v]) ? check(nums[v], repeatStartNum, cnt + 1) : 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int p = sc.nextInt();
		
		sc.close();

		visited[a] = true;
		
		int nextNum = a;
		
		while (true) {
			int currNum = nextNum;
			
			String num = Integer.toString(currNum);
			
			nextNum = 0;
			
			for (int i = 0; i < num.length(); ++i) {
				nextNum += Math.pow(num.charAt(i) - '0', p);
			}
			
			if (visited[nextNum]) {
				break;
			}
			
			nums[currNum] = nextNum;
			visited[nextNum] = true;
		}
		
		System.out.print(check(a, nextNum, 1));
	}

}
