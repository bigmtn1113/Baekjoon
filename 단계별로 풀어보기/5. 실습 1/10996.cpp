#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, i, j;

	cin >> n;
	
	if (n == 1) { cout << '*'; return 0; }

	for (i = 0; i < n * 2; ++i) {
		if (i % 2 == 0) {
			for (j = 0; j < n; ++j) {
				if (j % 2 == 0) cout << '*';
				else cout << ' ';
			}
			cout << '\n';
		}
		else {
			for (j = 0; j < n; ++j) {
				if (j % 2 != 0) cout << '*';
				else cout << ' ';
			}
			cout << '\n';
		}
	}
}