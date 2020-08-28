#include <iostream>
#include <cstdio>

using namespace std;

int dp[101][10];

int main() {
	int n;
	int sum = 0, mod = 1000000000;

	scanf("%d", &n);

	for (int i = 1; i <= 9; i++)
		dp[1][i] = 1;

	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= 9; j++) {
			if (j == 0)
				dp[i][j] = dp[i - 1][j + 1] % mod;
			else if (j == 9)
				dp[i][j] = dp[i - 1][j - 1] % mod;
			else
				dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
		}
	}

	for (int i = 0; i <= 9; i++)
		sum = (sum + dp[n][i]) % mod;

	printf("%d", sum % mod);
}