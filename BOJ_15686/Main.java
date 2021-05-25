import java.util.ArrayList;
import java.util.Scanner;

class Location {
	private int r;
	private int c;
	
	public Location(int r, int c) {
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
	public static int answer = Integer.MAX_VALUE;
	
	public static void recursionFunc(ArrayList<Location> housesLocation, ArrayList<Location> storesLocation, int m, int preIndex, String storesNum) {
		if ((storesNum.split(" ").length == m) && (preIndex > -1)) {
			String[] temp = storesNum.split(" ");
			int[] stores = new int[m];
			
			for (int i = 0; i < m; ++i) {
				stores[i] = Integer.parseInt(temp[i]);
			}
			
			int distanceSum = 0;
			
			// m개의 가게들과 집들의 거리 계산
			for (Location houseLocation : housesLocation) {
				int houseR = houseLocation.getR();
				int houseC = houseLocation.getC();
				
				int minDistance = Integer.MAX_VALUE;
				
				for (int i = 0; i < m; ++i) {
					int storeR = storesLocation.get(stores[i]).getR();
					int storeC = storesLocation.get(stores[i]).getC();
					
					minDistance = Math.min(minDistance, Math.abs(houseR - storeR) + Math.abs(houseC - storeC));
				}
				
				distanceSum += minDistance;
			}
			
			answer = Math.min(answer, distanceSum);
			return;
		}
		
		for (int i = preIndex + 1; i < storesLocation.size(); ++i) {
			recursionFunc(housesLocation, storesLocation, m, i, storesNum + i + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] city = new int[n][n];
		
		ArrayList<Location> housesLocation = new ArrayList<>();
		ArrayList<Location> storesLocation = new ArrayList<>();
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				city[i][j] = sc.nextInt();
				
				if (city[i][j] == 1) {
					housesLocation.add(new Location(i, j));
				} else if (city[i][j] == 2) {
					storesLocation.add(new Location(i, j));
				}
			}
		}
		
		sc.close();
		
		// 최대 m개는 함정. m개로 했을 경우 answer이 최소가 됨.
		recursionFunc(housesLocation, storesLocation, m, -1, "");
		
		System.out.print(answer);
	}

}
