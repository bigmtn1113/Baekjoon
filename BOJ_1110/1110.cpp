#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	int temp, cnt = 0;

	cin >> N;

	temp = N;
	while (true) {
		temp = (temp % 10 * 10) + (temp / 10 + temp % 10) % 10;

		cnt++;
		if (temp == N)
			break;
	}
	cout << cnt;
}

// 26 -> (6 * 10) + (2 + 6) = 68
// 9 -> (9 * 10) + (0 + 9) = 99