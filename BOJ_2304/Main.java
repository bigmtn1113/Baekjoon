import java.util.Arrays;
import java.util.Scanner;

class Pillar implements Comparable<Pillar> {
	private int location;
	private int height;
	
	public Pillar(int location, int height) {
		this.location = location;
		this.height = height;
	}

	public int getLocation() {
		return location;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public int compareTo(Pillar o) {
		return this.location - o.location;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Pillar[] pillarArray = new Pillar[n];
		
		for (int i = 0; i < n; ++i) {
			pillarArray[i] = new Pillar(sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(pillarArray);
		
		int answer = 0;
		
		for (int i = 0; i < n; ++i) {
			int currPillarLocation = pillarArray[i].getLocation();
			int currPillarHeight = pillarArray[i].getHeight();
			int nextPillarLocation = 0;
			int nextPillarHeight = 0;
			
			answer += currPillarHeight;
			
			if (i == n - 1) {
				break;
			}
			
			boolean check = false;
			
			for (int j = i + 1; j < n; ++j) {
				if (pillarArray[j].getHeight() > currPillarHeight) {	// 오른쪽에 현재 기둥보다 높은 기둥이 있을 경우
					i = j;
					
					answer += (pillarArray[j].getLocation() - (currPillarLocation + 1)) * currPillarHeight;
					check = true;
					break;
				}
				
				if (pillarArray[j].getHeight() > nextPillarHeight) {	// 오른쪽에서 현재 기둥보다 낮은 기둥 중 가장 높은 기둥 찾기
					i = j;
					
					nextPillarLocation = pillarArray[j].getLocation();
					nextPillarHeight = pillarArray[j].getHeight();
				}
			}
			
			if (!check) {		// 오른쪽에 현재 기둥보다 높은 기둥이 없을 경우
				answer += (nextPillarLocation - (currPillarLocation + 1)) * nextPillarHeight;
			}
			
			--i;
		}
		
		System.out.print(answer);
	}

}
