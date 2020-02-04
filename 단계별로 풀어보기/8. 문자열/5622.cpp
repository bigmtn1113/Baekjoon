#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int alphabet[26] = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
	int time = 0;
	string str;

	cin >> str;
	for (int i = 0; i < str.length(); i++)
		time += alphabet[(int)str[i] - 65] + 1;

	cout << time;
}