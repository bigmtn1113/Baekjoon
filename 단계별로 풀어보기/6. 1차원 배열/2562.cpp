#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int num, index;
	int max = -0x7fffffff;

	for (int i = 1; i <= 9; i++) {
		cin >> num;
		if (num > max) {
			max = num;
			index = i;
		}
	}
	cout << max << '\n' << index;
}