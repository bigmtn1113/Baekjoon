#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, count = 0;

	cin >> n;
	for (int i = 0; i <= n / 5; i++)
		for (int j = 0; j <= n / 3; j++)
			if (5 * i + 3 * j == n)
				count = i + j;

	cout << (count != 0 ? count : -1);
}