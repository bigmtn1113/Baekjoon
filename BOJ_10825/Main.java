import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student> {
	private String name;
	private int korean;
	private int english;
	private int math;
	
	public Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public int getKorean() {
		return korean;
	}

	public int getEnglish() {
		return english;
	}

	public int getMath() {
		return math;
	}

	@Override
	public int compareTo(Student o) {
		if (o.korean == korean) {
			if (o.english == english) {
				if (o.math == math) {
					return name.compareTo(o.name);
				}
				
				return o.math - math;
			}
			
			return english - o.english;
		}
		
		return o.korean - korean;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Student[] student = new Student[n];
		
		for (int i = 0; i < n; ++i) {
			student[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(student);
		
		StringBuilder answer = new StringBuilder();
		
		for (Student s : student) {
			answer.append(s.getName()).append("\n");
		}
		
		System.out.print(answer);
	}
	
}
