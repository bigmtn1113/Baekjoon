#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int rgb_cost[1001][3];
int mem[1001][3];

int main() {
	int n;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < 3; j++)
			scanf("%d", &rgb_cost[i][j]);

	mem[0][0] = rgb_cost[0][0];
	mem[0][1] = rgb_cost[0][1];
	mem[0][2] = rgb_cost[0][2];

	for (int i = 1; i < n; i++) {
		mem[i][0] = rgb_cost[i][0] + min(mem[i - 1][1], mem[i - 1][2]);
		mem[i][1] = rgb_cost[i][1] + min(mem[i - 1][0], mem[i - 1][2]);
		mem[i][2] = rgb_cost[i][2] + min(mem[i - 1][0], mem[i - 1][1]);
	}

	printf("%d", min({ mem[n - 1][0], mem[n - 1][1], mem[n - 1][2] }));
}