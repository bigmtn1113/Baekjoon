#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int dp[10001];
int grape[10001];

int main() {
	int n;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &grape[i]);

	dp[0] = grape[0];
	dp[1] = grape[0] + grape[1];
	dp[2] = max({ dp[1], grape[2] + grape[1], grape[2] + grape[0] });

	for (int i = 3; i < n; i++)
		dp[i] = max({ dp[i - 1], grape[i] + grape[i - 1] + dp[i - 3], grape[i] + dp[i - 2] });

	printf("%d", dp[n - 1]);
}