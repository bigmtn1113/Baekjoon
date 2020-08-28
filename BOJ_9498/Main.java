import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int grade = sc.nextInt();
		sc.close();
		
		if (90 <= grade && grade <= 100) System.out.print("A");
		else if (80 <= grade && grade <= 89) System.out.print("B");
		else if (70 <= grade && grade <= 79) System.out.print("C");
		else if (60 <= grade && grade <= 69) System.out.print("D");
		else System.out.print("F");
	}

}
