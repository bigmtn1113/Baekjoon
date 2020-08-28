#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int m, n;
	bool arr[1000001] = { 1, 1, };

	cin >> m >> n;

	for (int i = 2; i * i <= n; i++)
		if (arr[i] == 0)
			for (int j = i * i; j <= n; j += i)
				arr[j] = 1;

	for (int i = m; i <= n; i++)
		if (arr[i] == 0)
			cout << i << '\n';
}