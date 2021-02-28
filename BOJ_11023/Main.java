import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		
		sc.close();
		
		String[] inputArray = input.split(" ");
		int sum = 0;
		
		for (String inputNum : inputArray) {
			sum += Integer.parseInt(inputNum);
		}
		
		System.out.print(sum);
	}
	
}
