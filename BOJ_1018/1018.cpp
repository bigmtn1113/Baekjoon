#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n, m, count, count_a, count_b, min = 0x7fffffff;
	char board[51][51];

	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			scanf(" %c", &board[i][j]);

	for (int i = 0; i <= n - 8; i++) {
		for (int j = 0; j <= m - 8; j++) {
			count_a = 0;
			count_b = 0;

			for (int k = i; k < i + 8; k++) {
				for (int l = j; l < j + 8; l++) {
					if (k % 2 == 0 && l % 2 == 0 && board[k][l] != 'B') count_a++;
					if (k % 2 == 0 && l % 2 == 1 && board[k][l] != 'W') count_a++;
					if (k % 2 == 1 && l % 2 == 0 && board[k][l] != 'W') count_a++;
					if (k % 2 == 1 && l % 2 == 1 && board[k][l] != 'B') count_a++;

					if (k % 2 == 0 && l % 2 == 0 && board[k][l] != 'W') count_b++;
					if (k % 2 == 0 && l % 2 == 1 && board[k][l] != 'B') count_b++;
					if (k % 2 == 1 && l % 2 == 0 && board[k][l] != 'B') count_b++;
					if (k % 2 == 1 && l % 2 == 1 && board[k][l] != 'W') count_b++;
				}
			}

			count = count_a < count_b ? count_a : count_b;
			if (min > count) min = count;
		}
	}

	printf("%d", min);
}