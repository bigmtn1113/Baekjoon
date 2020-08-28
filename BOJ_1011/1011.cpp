#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t;
	long long x, y, destination, sum, cnt;

	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> x >> y;

		destination = y - x;
		sum = 0;
		cnt = 1;

		while (true) {
			sum += cnt * 2;
			if (sum == destination) { cout << cnt * 2 << '\n'; break; }
			if (sum > destination) {
				sum -= cnt--;

				if (sum >= destination) { cout << cnt * 2 + 1 << '\n'; break; }
				else { cout << cnt * 2 + 2 << '\n'; break; }
			}
			cnt++;
		}
	}
}