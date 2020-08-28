#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, count = 0;
	string num;

	cin >> n;
	for (int i = 1; i <= n; i++) {
		if (i < 100)
			count++;
		else {
			num = to_string(i);
			if (num[1] - num[0] == num[2] - num[1])
				count++;
		}
	}
	cout << count;
}