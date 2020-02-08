#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int main() {
	int n, sum;
	int p[1001], dp[1001];

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &p[i]);

	sort(p, p + n);

	sum = dp[0] = p[0];
	for (int i = 1; i < n; i++) {
		dp[i] = dp[i - 1] + p[i];
		sum += dp[i];
	}

	printf("%d", sum);
}