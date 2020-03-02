#include <iostream>

using namespace std;

int dp[1500001] = { 0, 1 };

int Fibonachi(unsigned long long n) {
	if (!n) return dp[0];
	if (n == 1) return dp[1];

	if (!dp[n]) return dp[n] = (Fibonachi(n - 1) + Fibonachi(n - 2)) % 1000000;
	return dp[n];
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	unsigned long long n;

	cin >> n;
	cout << Fibonachi(n % 1500000);
}

// 피사노 주기이용
// 나머지가 1,000,000일때 1,500,000을 기준으로 배열값이 반복되는 걸 알 수 있다.