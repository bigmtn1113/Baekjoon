import java.util.Arrays;
import java.util.Scanner;

class Olympic implements Comparable<Olympic>{
	private int nation;
	private int gold;
	private int silver;
	private int bronze;
	private int rank;
	
	public Olympic(int nation, int gold, int silver, int bronze) {
		this.nation = nation;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		this.rank = 0;
	}

	public int getNation() {
		return nation;
	}

	public int getGold() {
		return gold;
	}

	public int getSilver() {
		return silver;
	}

	public int getBronze() {
		return bronze;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Olympic o) {
		if (o.getGold() == gold) {
			if (o.getSilver() == silver) {
				return o.getBronze() - bronze;
			}
			
			return o.getSilver() - silver;
		}
		
		return o.getGold() - gold;
	}
}

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Olympic[] olympic = new Olympic[n];
		
		for (int i = 0; i < n; ++i) {
			olympic[i] = new Olympic(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		Arrays.sort(olympic);
		
		int rank = 0;
		
		for (int i = 0; i < n; ) {
			int gold = olympic[i].getGold();
			int silver = olympic[i].getSilver();
			int bronze = olympic[i].getBronze();
			
			olympic[i].setRank(++rank);
			
			if (olympic[i].getNation() == k) {
				System.out.print(olympic[i].getRank());
				break;
			}
			
			int cnt = 0;
			
			for (int j = i + 1; j < n; ++j) {
				i = j;
				
				if ((olympic[j].getGold() == gold)
						&& (olympic[j].getSilver() == silver)
						&& (olympic[j].getBronze() == bronze)) {
					olympic[j].setRank(rank);
					++cnt;
					
					if (olympic[j].getNation() == k) {
						System.out.print(olympic[j].getRank());
						System.exit(0);
					}
				} else {
					rank += cnt;
					break;
				}
			}
		}
	}
	
}
