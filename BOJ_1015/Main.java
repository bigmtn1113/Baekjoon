import java.util.Arrays;
import java.util.Scanner;

class Sequence implements Comparable<Sequence> {
	private int num;
	private int index;
	
	public Sequence(int num, int index) {
		this.num = num;
		this.index = index;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getNum() {
		return num;
	}
	
	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(Sequence o) {
		return num - o.num;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Sequence[] sequence = new Sequence[n];
		
		for (int i = 0; i < n; ++i) {
			sequence[i] = new Sequence(sc.nextInt(), i);
		}
		
		sc.close();
		
		Arrays.sort(sequence);

		for (int i = 0; i < n; ++i) {
			sequence[i].setNum(sequence[i].getIndex());
			sequence[i].setIndex(i);
		}
		
		Arrays.sort(sequence);
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < n; ++i) {
			answer.append(sequence[i].getIndex()).append(" ");
		}
		
		System.out.print(answer);
	}

}
