#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int dp[1001][2];
int sequence[1001];

int main() {
	int n, dp_sum = 0;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &sequence[i]);

	for (int i = 0; i < n; i++)
		dp[i][0] = dp[i][1] = 1;

	for (int i = 1; i < n; i++)
		for (int j = 0; j < i; j++) {
			if (sequence[i] > sequence[j])
				dp[i][0] = max(dp[i][0], dp[j][0] + 1);
			if (sequence[n - 1 - i] > sequence[n - 1 - j])
				dp[n - 1 - i][1] = max(dp[n - 1 - i][1], dp[n - 1 - j][1] + 1);
		}

	for (int i = 0; i < n; i++)
		if (dp[i][0] + dp[i][1] > dp_sum)
			dp_sum = dp[i][0] + dp[i][1];

	printf("%d", dp_sum - 1);
}