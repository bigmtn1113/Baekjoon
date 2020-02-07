#include <iostream>
#include <cstdio>

using namespace std;

int triangle[501][501];
int mem[501][501];

int main() {
	int n, max = -1;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < i + 1; j++)
			scanf("%d", &triangle[i][j]);

	mem[0][0] = triangle[0][0];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < i + 1; j++) {
			if (mem[i + 1][j] < mem[i][j] + triangle[i + 1][j])
				mem[i + 1][j] = mem[i][j] + triangle[i + 1][j];
			if (mem[i + 1][j + 1] < mem[i][j] + triangle[i + 1][j + 1])
				mem[i + 1][j + 1] = mem[i][j] + triangle[i + 1][j + 1];
		}
	}

	for (int i = 1; i < n; i++)
		if (mem[n - 1][i] > max)
			max = mem[n - 1][i];

	printf("%d", max);
}