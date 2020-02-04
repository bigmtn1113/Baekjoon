#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string str;
	int max = 0, check = 0, pos = 0;
	int alphabet[26] = {};

	cin >> str;
	for (int i = 0; i < str.length(); i++)
		alphabet[(int)tolower(str[i]) - 97]++;

	for (int i = 0; i < 26; i++)
		if (alphabet[i] > max) {
			max = alphabet[i];
			pos = i;
		}

	for (int i = 0; i < 26; i++)
		if (alphabet[i] == max)
			check++;

	if (check != 1)
		cout << "?";
	else
		cout << (char)(pos + 65);
}