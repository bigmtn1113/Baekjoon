import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int j = sc.nextInt();
		
		int leftOfBasket = 1;
		int rightOfBasket = m;
		
		int movementCnt = 0;
		
		for (int i = 0; i < j; ++i) {
			int apple = sc.nextInt();
			
			if (apple > rightOfBasket) {
				movementCnt += apple - rightOfBasket;
				
				leftOfBasket += apple - rightOfBasket;
				rightOfBasket = apple;
			} else if (apple < leftOfBasket) {
				movementCnt += leftOfBasket - apple;
				
				rightOfBasket -= leftOfBasket - apple;
				leftOfBasket = apple;
			}
		}
		
		sc.close();
		
		System.out.print(movementCnt);
	}
	
}
