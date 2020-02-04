#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int c, n;
	int sum, count;
	int score[1001] = { 0 };
	float average;

	cin >> c;
	for (int i = 0; i < c; i++) {
		cin >> n;
		sum = 0;
		count = 0;

		for (int j = 0; j < n; j++) {
			cin >> score[j];
			sum += score[j];
		}
		average = (float)sum / (float)n;
		for (int j = 0; j < n; j++)
			if (score[j] > average)
				count++;

		cout << fixed;
		cout.precision(3);
		cout << (float)count / n * 100 << "%" << '\n';
	}
}