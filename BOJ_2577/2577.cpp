#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int A, B, C;
	int arr[10] = { 0 };
	string result;

	cin >> A >> B >> C;
	result = to_string(A * B * C);

	for (int i = 0; i < result.length(); i++)
		arr[result[i] - '0']++;

	for (int i = 0; i < 10; i++)
		cout << arr[i] << '\n';
}