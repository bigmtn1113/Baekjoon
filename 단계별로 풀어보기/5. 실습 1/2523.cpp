#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 0; i < 2 * n - 1; ++i) {
		int j;
		if (i < n) {
			for (j = 0; j <= i; ++j)
				cout << '*';
			cout << '\n';
		}
		else {
			--j;
			for (int k = j; k > 0; --k)
				cout << '*';
			cout << '\n';
		}
	}
}