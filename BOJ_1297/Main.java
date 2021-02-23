import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int diagonal = sc.nextInt();
		int heightRatio = sc.nextInt();
		int widthRatio = sc.nextInt();
		
		sc.close();
		
		double diagonalRatio = Math.sqrt(heightRatio * heightRatio + widthRatio * widthRatio);
		int height = (int) Math.floor(diagonal / diagonalRatio * heightRatio);
		int width = (int) Math.floor(diagonal / diagonalRatio * widthRatio);
		
		System.out.print(height + " " + width);
	}
	
}
