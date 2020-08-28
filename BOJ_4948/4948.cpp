#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, cnt;
	bool arr[123456 * 2 + 1];

	while (true) {
		cin >> n;
		if (n == 0) return 0;

		fill_n(arr, n * 2 + 1, 0);
		arr[0] = arr[1] = 1;

		cnt = 0;
		for (int i = 2; i * i <= n * 2; i++)
			if (arr[i] == 0)
				for (int j = i * i; j <= n * 2; j += i)
					arr[j] = 1;

		for (int i = n + 1; i <= n * 2; i++)
			if (arr[i] == 0)
				cnt++;

		cout << cnt << '\n';
	}
}