import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

class WaterBottles {
	private int a;
	private int b;
	private int c;
	
	public WaterBottles(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((obj != null) && obj instanceof WaterBottles) {
			WaterBottles o = (WaterBottles) obj;
			
			if ((this.a == o.a) && (this.b == o.b) && (this.c == o.c)) {
				return true;
			}
		}
		
		return false;
	}
}

public class Main {
	public static ArrayList<WaterBottles> bfs(int a, int b, int c) {
		ArrayList<WaterBottles> list = new ArrayList<>();
		
		Queue<WaterBottles> queue = new LinkedList<>();
		queue.offer(new WaterBottles(0, 0, c));
		
		while (!queue.isEmpty()) {
			list.add(queue.peek());
			
			int currA = queue.peek().getA();
			int currB = queue.peek().getB();
			int currC = queue.poll().getC();
			
			int nextA = 0;
			int nextB = 0;
			int nextC = 0;
			
			if (currC != 0) {
				if (currA < a) {
					if (currA + currC <= a) {
						nextA = currA + currC;
						nextC = 0;
					} else {
						nextA = a;
						nextC = currA + currC - a;
					}
					
					WaterBottles next = new WaterBottles(nextA, currB, nextC);
					
					if (!list.contains(next)) {
						queue.offer(next);
					}
				}
				
				if (currB < b) {
					if (currB + currC <= b) {
						nextB = currB + currC;
						nextC = 0;
					} else {
						nextB = b;
						nextC = currB + currC - b;
					}
					
					WaterBottles next = new WaterBottles(currA, nextB, nextC);
					
					if (!list.contains(next)) {
						queue.offer(next);
					}
				}
			}
			
			if (currA != 0) {
				if (currB < b) {
					if (currB + currA <= b) {
						nextB = currB + currA;
						nextA = 0;
					} else {
						nextB = b;
						nextA = currB + currA - b;
					}
					
					WaterBottles next = new WaterBottles(nextA, nextB, currC);
					
					if (!list.contains(next)) {
						queue.offer(next);
					}
				}
				
				if (currC < c) {
					if (currC + currA <= c) {
						nextC = currC + currA;
						nextA = 0;
					} else {
						nextC = c;
						nextA = currC + currA - c;
					}
					
					WaterBottles next = new WaterBottles(nextA, currB, nextC);
					
					if (!list.contains(next)) {
						queue.offer(next);
					}
				}
			}
			
			if (currB != 0) {
				if (currA < a) {
					if (currA + currB <= a) {
						nextA = currA + currB;
						nextB = 0;
					} else {
						nextA = a;
						nextB = currA + currB - a;
					}
					
					WaterBottles next = new WaterBottles(nextA, nextB, currC);
					
					if (!list.contains(next)) {
						queue.offer(next);
					}
				}
				
				if (currC < c) {
					if (currC + currB <= c) {
						nextC = currC + currB;
						nextB = 0;
					} else {
						nextC = c;
						nextB = currC + currB - c;
					}
					
					WaterBottles next = new WaterBottles(currA, nextB, nextC);
					
					if (!list.contains(next)) {
						queue.offer(next);
					}
				}
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		sc.close();
		
		ArrayList<WaterBottles> list = bfs(a, b, c);
		TreeSet<Integer> treeSet = new TreeSet<>();
		
		for (WaterBottles item : list) {
			if (item.getA() == 0) {
				treeSet.add(item.getC());
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int item : treeSet) {
			answer.append(item).append(" ");
		}
		
		System.out.print(answer);
	}

}
