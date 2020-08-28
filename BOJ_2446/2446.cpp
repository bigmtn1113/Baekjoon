#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, i, j, k;

	cin >> n;
	for (i = 0; i < 2 * n - 1; ++i) {
		if (i < n) {
			for (j = 0; j < i; ++j)
				cout << ' ';
			for (j = 0; j < (2 * n - 1) - (i * 2); ++j)
				cout << '*';
			cout << '\n';

			j = i;
		}
		else {
			--j;
			for (k = 0; k < j; ++k)
				cout << ' ';
			for (k = 0; k < (2 * n - 1) - (j * 2); ++k)
				cout << '*';
			cout << '\n';
		}
	}
}