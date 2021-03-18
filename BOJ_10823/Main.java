import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String input = "";
		
		while (sc.hasNext()) {
			input += sc.next();
		}
		
		sc.close();
		
		String[] numStrArray = input.split(",");
		int sum = 0;
		
		for (int i = 0; i < numStrArray.length; ++i) {
			sum += Integer.parseInt(numStrArray[i]);
		}
		
		System.out.print(sum);
	}
	
}
