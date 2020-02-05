#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int i, x = 1, y = 1, inc = 1, cnt = 1;
	int n;

	cin >> n;
	while (true) {
		for (i = 1; i <= inc; i++) {
			y++; cnt++;
			if (x != 1) x--;
			if (cnt == n) { cout << x << "/" << y; return 0; }
		}
		inc++;
		for (i = 1; i <= inc; i++) {
			x++; cnt++;
			if (y != 1) y--;
			if (cnt == n) { cout << x << "/" << y; return 0; }
		}
		inc++;
	}
}