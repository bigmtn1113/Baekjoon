#include <iostream>
#include <cstdio>

using namespace std;

int dp[1001];
int sequence[1001];

int main() {
	int n, max = 0;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &sequence[i]);

	for (int i = 1; i < n; i++)
		for (int j = 0; j < i; j++)
			if (sequence[i] > sequence[j] && dp[j] >= dp[i])
				dp[i] = dp[j] + 1;

	for (int i = 0; i < n; i++)
		if (dp[i] > max)
			max = dp[i];

	printf("%d", max + 1);
}