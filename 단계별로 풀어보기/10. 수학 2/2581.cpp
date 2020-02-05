#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int m, n, min = 0, sum = 0;
	bool is_prime_number, is_min = true;

	cin >> m >> n;
	for (int i = m; i <= n; i++) {
		is_prime_number = false;

		for (int div = 2; div <= i; div++) {
			if (div != i && i % div == 0) break;
			if (div == i) is_prime_number = true;
		}

		if (is_prime_number) {
			if (is_min) { min = i; is_min = false; }
			sum += i;
		}
	}

	if (sum == 0) cout << -1;
	else cout << sum << '\n' << min;
}