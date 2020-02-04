#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, sum = 0;
	string num;

	cin >> n;
	cin >> num;
	for (int i = 0; i < n; i++)
		sum += num[i] - '0';
	cout << sum;
}