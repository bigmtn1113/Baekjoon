#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, min = 1, max = 1, room = 1;

	cin >> n;
	while (true) {
		if (min <= n && n <= max)
			break;
		min = max + 1;
		max += 6 * room;
		room++;
	}
	cout << room;
}