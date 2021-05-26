import java.util.Scanner;

public class Main {
	
	public static void rotate(char[] gear, int direction) {
		if (direction == 1) {
			char temp = gear[7];
			
			for (int i = 7; i > 0; --i) {
				gear[i] = gear[i - 1];
			}
			
			gear[0] = temp;
		} else {
			char temp = gear[0];
			
			for (int i = 0; i < 7; ++i) {
				gear[i] = gear[i + 1];
			}
			
			gear[7] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] gear = new char[5][8];
		
		for (int i = 1; i <= 4; ++i) {
			gear[i] = sc.next().toCharArray();
		}
		
		int k = sc.nextInt();
		
		for (int i = 0; i < k; ++i) {
			int gearNum = sc.nextInt();
			int direction = sc.nextInt();
			
			switch (gearNum) {
			case 1:
				if (gear[1][2] != gear[2][6]) {
					if (gear[2][2] != gear[3][6]) {
						if (gear[3][2] != gear[4][6]) {
							rotate(gear[4], (direction == 1) ? -1 : 1);
						}
						
						rotate(gear[3], direction);
					}
					
					rotate(gear[2], (direction == 1) ? -1 : 1);
				}
				
				rotate(gear[1], direction);
				break;
				
			case 2:
				if (gear[2][2] != gear[3][6]) {
					if (gear[3][2] != gear[4][6]) {
						rotate(gear[4], direction);
					}
					
					rotate(gear[3], (direction == 1) ? -1 : 1);
				}
				
				if (gear[2][6] != gear[1][2]) {
					rotate(gear[1], (direction == 1) ? -1 : 1);
				}
				
				rotate(gear[2], direction);
				break;
				
			case 3:
				if (gear[3][2] != gear[4][6]) {
					rotate(gear[4], (direction == 1) ? -1 : 1);
				}
				
				if (gear[3][6] != gear[2][2]) {
					if (gear[2][6] != gear[1][2]) {
						rotate(gear[1], direction);
					}
					
					rotate(gear[2], (direction == 1) ? -1 : 1);
				}
				
				rotate(gear[3], direction);
				break;
				
			default:
				if (gear[4][6] != gear[3][2]) {
					if (gear[3][6] != gear[2][2]) {
						if (gear[2][6] != gear[1][2]) {
							rotate(gear[1], (direction == 1) ? -1 : 1);
						}
						
						rotate(gear[2], direction);
					}
					
					rotate(gear[3], (direction == 1) ? -1 : 1);
				}
				
				rotate(gear[4], direction);
				break;
			}
		}
		
		sc.close();
		
		int answer = 0;
		
		for (int i = 1; i <= 4; ++i) {
			answer += (gear[i][0] == '0') ? 0 : Math.pow(2, i - 1);
		}
		
		System.out.print(answer);
	}

}
