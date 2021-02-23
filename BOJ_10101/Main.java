import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int[] angle = new int[3];
		int angleSum = 0;
		
		for (int i = 0; i < 3; ++i) {
			angle[i] = sc.nextInt();
			angleSum += angle[i];
		}
		
		sc.close();
		
		String triangleType = "";
		
		if (angleSum == 180) {
			if ((angle[0] == 60) && (angle[1] == 60) && (angle[2] == 60)) {
				triangleType = "Equilateral";
			} else if ((angle[0] == angle[1]) || (angle[0] == angle[2]) || (angle[1] == angle[2])) {
				triangleType = "Isosceles";
			} else {
				triangleType = "Scalene";
			}
		} else {
			triangleType = "Error";
		}
		
		System.out.print(triangleType);
	}
	
}
