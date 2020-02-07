#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int dp[1000001];
int n;

int main() {
	scanf("%d", &n);

	dp[2] = dp[3] = 1;

	for (int i = 4; i <= n; i++) {
		if (i % 3 == 0)
			dp[i] = min(dp[i / 3], dp[i - 1]) + 1;
		else if (i % 2 == 0 && i % 3 != 0)
			dp[i] = min(dp[i / 2], dp[i - 1]) + 1;
		else if (i % 3 != 0 && i % 2 != 0)
			dp[i] = dp[i - 1] + 1;
	}

	printf("%d", dp[n]);
}