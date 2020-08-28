#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, x, cnt = 0;
	bool is_prime_number;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x;
		is_prime_number = false;

		for (int div = 2; div <= x; div++) {
			if (div != x && x % div == 0) break;
			if (div == x) is_prime_number = true;
		}
		if (is_prime_number == true) cnt++;
	}

	cout << cnt;
}