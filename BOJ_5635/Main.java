import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
	private String name;
	private int day;
	private int month;
	private int year;
	
	public Student(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getName() {
		return name;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	@Override
	public int compareTo(Student o) {
		if (year == o.year) {
			if (month == o.month) {
				return day - o.day;
			}
			
			return month - o.month;
		}
		
		return year - o.year;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Student[] students = new Student[n];
		
		for (int i = 0; i < n; ++i) {
			students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(students);
		
		System.out.print(students[n - 1].getName() + "\n" + students[0].getName());
	}
	
}
