#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int test, rep;
	string str;

	cin >> test;

	for (int i = 0; i < test; i++) {
		cin >> rep >> str;

		for (int j = 0; j < str.length(); j++)
			for (int k = 0; k < rep; k++)
				cout << str[j];

		cout << endl;
	}
}