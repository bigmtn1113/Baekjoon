#include <iostream>

#define MIN(X, Y) ((X < Y) ? (X) : (Y))

using namespace std;

int dp[1000001] = { 0, 0, 1, 1, };

// Top-Down
// n을 1로 만드는 방법에 포함되어 있는 수 출력하기
void PrintDp(int n) {
	cout << n << ' ';
	if (n == 1) return;

	if (n % 3 != 0 && n % 2 != 0) PrintDp(n - 1);
	else if (n % 3 == 0 && n % 2 == 0) (dp[n / 3] < dp[n / 2]) ? PrintDp(n / 3) : PrintDp(n / 2);
	else if (n % 3 == 0 && n % 2 != 0) (dp[n / 3] < dp[n - 1]) ? PrintDp(n / 3) : PrintDp(n - 1);
	else if (n % 3 != 0 && n % 2 == 0) (dp[n / 2] < dp[n - 1]) ? PrintDp(n / 2) : PrintDp(n - 1);
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;

	// Bottom-Up
	// n을 1로 만드는 방법의 최솟값 구하기
	for (int i = 4; i <= n; ++i) {
		if (i % 3 != 0 && i % 2 != 0) dp[i] = dp[i - 1] + 1;
		else if (i % 3 == 0 && i % 2 == 0) dp[i] = MIN(dp[i / 3], dp[i / 2]) + 1;
		else if (i % 3 == 0 && i % 2 != 0) dp[i] = MIN(dp[i / 3], dp[i - 1]) + 1;
		else if (i % 3 != 0 && i % 2 == 0) dp[i] = MIN(dp[i / 2], dp[i - 1]) + 1;
	}

	cout << dp[n] << '\n';
	PrintDp(n);
}