#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, h, w, n, floor, room;

	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> h >> w >> n;

		n--;
		floor = n % h + 1;
		room = n / h + 1;

		cout << floor;
		if (room >= 10) cout << room << '\n';
		else cout << "0" << room << '\n';
	}
}