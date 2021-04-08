import java.util.Arrays;
import java.util.Scanner;

class Dot implements Comparable<Dot> {
	private int location;
	private int color;
	
	public Dot(int location, int color) {
		this.location = location;
		this.color = color;
	}

	public int getLocation() {
		return location;
	}

	public int getColor() {
		return color;
	}

	@Override
	public int compareTo(Dot o) {
		if (color == o.color) {
			return location - o.location;
		}
		
		return color - o.color;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		Dot[] dots = new Dot[n];
		
		for (int i = 0; i < n; ++i) {
			dots[i] = new Dot(sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(dots);
		
		int preDistanceDifference = dots[1].getLocation() - dots[0].getLocation();
		int answer = preDistanceDifference;
		
		for (int i = 1; i < n - 1; ++i) {
			if (dots[i + 1].getColor() != dots[i].getColor()) {
				answer += preDistanceDifference;
				preDistanceDifference = 100000;
				
				continue;
			}
			
			int distanceDifference = dots[i + 1].getLocation() - dots[i].getLocation();
			
			answer += (distanceDifference < preDistanceDifference) ? distanceDifference : preDistanceDifference;
			preDistanceDifference = distanceDifference;
		}
		
		System.out.print(answer + (dots[n - 1].getLocation() - dots[n - 2].getLocation()));
	}

}
