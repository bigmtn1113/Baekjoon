#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int main() {
	int n;
	int sum_max = -0x7fffffff;
	int num[100001], dp[100001] = { 0 };

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &num[i]);

	dp[0] = num[0];
	for (int i = 1; i < n; i++)
		dp[i] = max(dp[i - 1] + num[i], num[i]);

	for (int i = 0; i < n; i++)
		if (dp[i] > sum_max)
			sum_max = dp[i];

	printf("%d", sum_max);
}