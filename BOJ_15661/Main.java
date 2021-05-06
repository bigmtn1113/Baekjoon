import java.util.Scanner;

public class Main {
	public static int[] startTeam;
	public static int startTeamArrayIndex = 0;
	public static int answer = Integer.MAX_VALUE;
	
	public static int[] makeLinkTeam(int[][] table) {
		int[] linkTeam = new int[table.length - startTeamArrayIndex];
		int linkTeamArrayIndex = 0;
		
		for (int i = 0; i < table.length; ++i) {
			boolean containsI = false;
			
			for (int player : startTeam) {
				if (i == player) {
					containsI = true;
					break;
				}
			}
			
			if (!containsI) {		// StartTeam 소속이 아닌 선수일 경우 linkTeam
				linkTeam[linkTeamArrayIndex++] = i;
			}
		}
		
		return linkTeam;
	}
	
	public static void calculateTeamStatDifference(int[][] table) {
		int startTeamStat = 0;
		
		for (int i = 0; i < startTeamArrayIndex; ++i) {
			for (int j = i + 1; j < startTeamArrayIndex; ++j) {
				startTeamStat += table[startTeam[i]][startTeam[j]] + table[startTeam[j]][startTeam[i]];
			}
		}
		
		int[] linkTeam = makeLinkTeam(table);
		int linkTeamStat = 0;
		
		for (int i = 0; i < linkTeam.length; ++i) {
			for (int j = i + 1; j < linkTeam.length; ++j) {
				linkTeamStat += table[linkTeam[i]][linkTeam[j]] + table[linkTeam[j]][linkTeam[i]];
			}
		}
		
		answer = Math.min(answer, Math.abs(startTeamStat - linkTeamStat));
	}
	
	public static void recursionFunc(int[][] table, int playerCntInStartTeam, int preIValue, int cnt) {
		if (cnt == playerCntInStartTeam) {		// startTeam이 완성됐으면 팀 능력치 차이 계산
			calculateTeamStatDifference(table);
			return;
		}
		
		for (int i = preIValue + 1; i < table.length; ++i) {
			startTeam[startTeamArrayIndex++] = i;
			recursionFunc(table, playerCntInStartTeam, i, cnt + 1);
			--startTeamArrayIndex;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] table = new int[n][n];
		
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				table[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		startTeam = new int[n];
		
		for (int playerCntInStartTeam = 1; playerCntInStartTeam < n - 1; ++playerCntInStartTeam) {
			recursionFunc(table, playerCntInStartTeam, -1, 0);
		}
		
		System.out.print(answer);
	}

}
