#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, n, min, save;
	bool arr[10001];

	cin >> t;
	for (int i = 0; i < t; i++) {
		cin >> n;
		fill_n(arr, n, 0);
		arr[0] = arr[1] = 1;

		for (int i = 2; i * i <= n; i++)
			if (arr[i] == 0)
				for (int j = i * i; j <= n; j += i)
					arr[j] = 1;
		min = n;
		for (int i = n; i > 1; i--)
			if (arr[i] == 0 && arr[n - i] == 0) {
				if (i - (n - i) < 0) break;
				if (min > i - (n - i)) {
					min = i - (n - i);
					save = i;
				}
			}

		cout << n - save << " " << save << '\n';
	}
}