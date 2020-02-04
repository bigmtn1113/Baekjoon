#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, num;
	int max = -0x7fffffff, min = 0x7fffffff;

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> num;
		if (num > max)
			max = num;
		if (num < min)
			min = num;
	}
	cout << min << " " << max;
}