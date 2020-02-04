#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string str;
	int alphabet[26];

	fill_n(alphabet, 26, -1);
	
	cin >> str;

	for (int i = 0; i < str.length(); i++)
		if (alphabet[(int)str[i] - 97] == -1)
			alphabet[(int)str[i] - 97] = i;

	for (int i = 0; i < 26; i++)
		cout << alphabet[i] << ' ';
}