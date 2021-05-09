import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	private long num;
	private int cnt;
	
	public Pair(long num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}

	public long getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}

public class Main {
	public static int bfs(int a, int b) {
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(a, 1));
		
		while (!queue.isEmpty()) {
			long currNum = queue.peek().getNum();
			int currCnt = queue.poll().getCnt();
			
			if (currNum == b) {
				return currCnt;
			}
			
			long nextNum = currNum * 2;
			
			if (nextNum <= b) {
				queue.offer(new Pair(nextNum, currCnt + 1));
			}
			
			nextNum = currNum * 10 + 1;
			
			if (nextNum <= b) {
				queue.offer(new Pair(nextNum, currCnt + 1));
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		sc.close();
		
		int answer = bfs(a, b);
		
		System.out.print((answer != -1) ? answer : -1);
	}

}
