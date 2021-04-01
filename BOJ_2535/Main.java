import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
	private int nation;
	private int no;
	private int score;
	
	public Student(int nation, int no, int score) {
		this.nation = nation;
		this.no = no;
		this.score = score;
	}

	public int getNation() {
		return nation;
	}

	public int getNo() {
		return no;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Student o) {
		return o.score - score;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Student[] students = new Student[n];
		
		for (int i = 0; i < n; ++i) {
			students[i] = new Student(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(students);
		
		int[] array = new int[n];
		int cnt = 0;
		
		for (int i = 0; i < n; ++i) {
			if (cnt == 3) {
				break;
			}
			
			if (array[students[i].getNation()] == 2) {
				continue;
			}
			
			++array[students[i].getNation()];
			++cnt;
			
			System.out.println(students[i].getNation() + " " + students[i].getNo());
		}
	}
	
}
