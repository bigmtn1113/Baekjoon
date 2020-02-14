#include <iostream>
#include <cstdio>

using namespace std;

int dp[11] = { 1, 1, };

int Factorial(int num) {
	if (num == 1) return dp[1];
	if (dp[num] != 0) return dp[num];
	return dp[num] = num * Factorial(num - 1);
}

int main() {
	int n, k;

	scanf("%d %d", &n, &k);
	printf("%d", Factorial(n) / (Factorial(k) * Factorial(n - k)));
}