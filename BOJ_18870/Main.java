import java.util.Arrays;
import java.util.Scanner;

class Coordinate implements Comparable<Coordinate> {
	private int num;
	private int index;
	private int compressedNum;
	
	public Coordinate(int num, int index, int compressedNum) {
		this.num = num;
		this.index = index;
		this.compressedNum = compressedNum;
	}

	public int getNum() {
		return num;
	}

	public int getIndex() {
		return index;
	}

	public int getCompressedNum() {
		return compressedNum;
	}

	public void setCompressedNum(int compressedNum) {
		this.compressedNum = compressedNum;
	}

	@Override
	public int compareTo(Coordinate o) {
		return this.num - o.num;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Coordinate[] array = new Coordinate[n];
		Coordinate[] tempArray = new Coordinate[n];
		
		for (int i = 0; i < n; ++i) {
			array[i] = new Coordinate(sc.nextInt(), i, 0);
			tempArray[i] = array[i];
		}
		
		sc.close();
		
		Arrays.sort(tempArray);
		
		for (int i = 1; i < n; ++i) {
			if (tempArray[i].getNum() > tempArray[i - 1].getNum()) {
				tempArray[i].setCompressedNum(tempArray[i - 1].getCompressedNum() + 1);
			} else {
				tempArray[i].setCompressedNum(tempArray[i - 1].getCompressedNum());
			}
		}
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < n; ++i) {
			answer.append(array[i].getCompressedNum()).append(" ");
		}
		
		System.out.print(answer);
	}

}
