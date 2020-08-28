#include <iostream>

using namespace std;

int count_people(int k, int n) {
	int count = 0;

	if (k == 0) return n;
	for (int i = 1; i <= n; i++)
		count += count_people(k - 1, i);
	return count;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, k, n;

	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> k >> n;
		cout << count_people(k, n) << '\n';
	}
}