#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int student[5], sum = 0;

	for (int i = 0; i < 5; ++i) {
		cin >> student[i];
		sum += (student[i] < 40) ? 40 : student[i];
	}

	cout << sum / 5;
}