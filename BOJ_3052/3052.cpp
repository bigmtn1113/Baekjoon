#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int num;
	int arr[42] = { 0 }, cnt = 0;

	for (int i = 0; i < 10; i++) {
		cin >> num;
		arr[num % 42]++;
	}
	for (int i = 0; i < 42; i++)
		if (arr[i] != 0)
			cnt++;

	cout << cnt;
}