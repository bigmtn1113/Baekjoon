#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, max = 0, max_index = 0;
	int a[1001], dp[1001] = {}, index[1001] = {}, sequence[1001] = {};

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];

	for (int i = 1; i < n; ++i)
		for (int j = 0; j < i; ++j)
			// ex)
			// i:		0  1  2  3  4  5
			// a:		10 20 10 30 20 50
			// dp:		0  1  0  2  1  3
			// index:	0  0  0  1  0  3
			if (a[i] > a[j] && dp[j] >= dp[i]) {
				dp[i] = dp[j] + 1;
				index[i] = j;

				// max: 가장 긴 증가하는 부분 수열의 길이
				// max_index: max의 인덱스
				if (dp[i] > max) {
					max = dp[i];
					max_index = i;
				}
			}

	// max_index:	5 -> 3 -> 1 -> 0
	// sequence:	50 -> 30 -> 20 -> 10
	for (int i = 0; i <= max; ++i) {
		sequence[i] = a[max_index];
		max_index = index[max_index];
	}


	cout << max + 1 << '\n';
	for (int i = max; i >= 0; --i)
		cout << sequence[i] << ' ';
}