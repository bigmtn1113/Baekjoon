#include <iostream>
#include <cstdio>

using namespace std;

int g_n, g_min = 0x7fffffff;
int g_stat[20][20];
int g_pick[20];
int g_start_team[10], g_link_team[10];

void MakeTeam(int cur, int cnt) {
	if (cnt == g_n / 2) {
		int start_index = 0, link_index = 0;
		int start_sum = 0, link_sum = 0;
		int result;

		for (int i = 0; i < g_n; i++) {
			if (g_pick[i] == 1) g_start_team[start_index++] = i;
			else g_link_team[link_index++] = i;
		}

		for (int i = 0; i < g_n / 2; i++)
			for (int j = i + 1; j < g_n / 2; j++) {
				start_sum += g_stat[g_start_team[i]][g_start_team[j]] + g_stat[g_start_team[j]][g_start_team[i]];
				link_sum += g_stat[g_link_team[i]][g_link_team[j]] + g_stat[g_link_team[j]][g_link_team[i]];
			}

		result = start_sum > link_sum ? start_sum - link_sum : link_sum - start_sum;
		if (g_min > result) g_min = result;
		return;
	}
	for (int i = cur; i < g_n; i++) {
		g_pick[i] = 1;
		MakeTeam(i + 1, cnt + 1);
		g_pick[i] = 0;
	}
}

int main() {
	scanf("%d", &g_n);

	for (int i = 0; i < g_n; i++)
		for (int j = 0; j < g_n; j++)
			scanf("%d", &g_stat[i][j]);

	MakeTeam(0, 0);
	printf("%d", g_min);
}