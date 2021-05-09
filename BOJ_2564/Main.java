import java.util.Scanner;

class ShopLocation {
	private int r;
	private int c;
	
	public ShopLocation(int r, int c) {
		this.r = r;
		this.c = c;
	}

	public int getR() {
		return r;
	}

	public int getC() {
		return c;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int shopCnt = sc.nextInt();
		
		ShopLocation[] shopLocations = new ShopLocation[shopCnt];
		
		for (int i = 0; i < shopCnt; ++i) {
			int direction = sc.nextInt();
			int distance = sc.nextInt();
			
			switch (direction) {
			case 1:
				shopLocations[i] = new ShopLocation(0, distance);
				break;

			case 2:
				shopLocations[i] = new ShopLocation(h, distance);
				break;
				
			case 3:
				shopLocations[i] = new ShopLocation(distance, 0);
				break;
				
			default:
				shopLocations[i] = new ShopLocation(distance, w);
				break;
			}
		}
		
		int donggeunR = sc.nextInt();
		int donggeunC = sc.nextInt();
		
		switch (donggeunR) {
		case 1:
			donggeunR = 0;
			break;

		case 2:
			donggeunR = h;
			break;
			
		case 3:
			donggeunR = donggeunC;
			donggeunC = 0;
			break;
			
		default:
			donggeunR = donggeunC;
			donggeunC = w;
			break;
		}
		
		sc.close();
		
		int answer = 0;
		
		if (donggeunR == 0) {
			for (int i = 0; i < shopCnt; ++i) {
				int shopR = shopLocations[i].getR();
				int shopC = shopLocations[i].getC();
				
				if (shopR == 0) {
					answer += Math.abs(donggeunC - shopC);
				} else if (shopR == h) {
					int leftSum = donggeunC + shopC;
					int rightSum = 2 * w - leftSum;
					
					answer += h + Math.min(leftSum, rightSum);
				} else if (shopC == 0) {
					answer += donggeunC + shopR;
				} else {
					answer += (w - donggeunC) + shopR;
				}
			}
		} else if (donggeunR == h) {
			for (int i = 0; i < shopCnt; ++i) {
				int shopR = shopLocations[i].getR();
				int shopC = shopLocations[i].getC();
				
				if (shopR == h) {
					answer += Math.abs(donggeunC - shopC);
				} else if (shopR == 0) {
					int leftSum = donggeunC + shopC;
					int rightSum = 2 * w - leftSum;
					
					answer += h + Math.min(leftSum, rightSum);
				} else if (shopC == 0) {
					answer += donggeunC + (h - shopR);
				} else {
					answer += (w - donggeunC) + (h - shopR);
				}
			}
		} else if (donggeunC == 0) {
			for (int i = 0; i < shopCnt; ++i) {
				int shopR = shopLocations[i].getR();
				int shopC = shopLocations[i].getC();
				
				if (shopC == 0) {
					answer += Math.abs(donggeunR - shopR);
				} else if (shopC == w) {
					int leftSum = donggeunR + shopR;
					int rightSum = 2 * w - leftSum;
					
					answer += h + Math.min(leftSum, rightSum);
				} else if (shopR == 0) {
					answer += donggeunR + shopC;
				} else {
					answer += (h - donggeunR) + shopC;
				}
			}
		} else {
			for (int i = 0; i < shopCnt; ++i) {
				int shopR = shopLocations[i].getR();
				int shopC = shopLocations[i].getC();
				
				if (shopC == w) {
					answer += Math.abs(donggeunR - shopR);
				} else if (shopC == 0) {
					int leftSum = (h - donggeunR) + (h - shopR);
					int rightSum = 2 * w - leftSum;
					
					answer += h + Math.min(leftSum, rightSum);
				} else if (shopR == 0) {
					answer += donggeunR + (w - shopC);
				} else {
					answer += (h - donggeunR) + (w - shopC);
				}
			}
		}
		
		System.out.print(answer);
	}

}
