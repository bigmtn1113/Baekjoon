import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] distanceArray = new int[n - 1];
		
		int preLocation = sc.nextInt();
		
		for (int i = 0; i < n - 1; ++i) {
			int location = sc.nextInt();
			
			distanceArray[i] = location - preLocation;
			preLocation = location;
		}
		
		sc.close();
		
		int[] gcdArray = distanceArray.clone();
		
		for (int i = 1; i < n - 1; ++i) {
			int tempA = gcdArray[i - 1];
			int tempB = gcdArray[i];
			
			if (tempA < tempB) {
				int temp = tempA;
				tempA = tempB;
				tempB = temp;
			}
			
			while (tempA % tempB != 0) {
				int temp = tempA;
				tempA = tempB;
				tempB = temp % tempB;
			}
			
			gcdArray[i] = tempB;
		}
		
		int answer = 0;
		
		for (int i = 0; i < n - 1; ++i) {
			answer += distanceArray[i] / gcdArray[n - 2] - 1;
		}
		
		System.out.print(answer);
	}

}
