#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int T, count, sum;
	string ox;

	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> ox;
		count = 0;
		sum = 0;
		for (int j = 0; j < ox.length(); j++) {
			if (ox[j] == 'O')
				sum += ++count;
			else if (ox[j] == 'X')
				count = 0;
		}
		cout << sum << endl;
	}
}