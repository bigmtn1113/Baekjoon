#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, not_group_word = 0;
	string str;
	char check;
	bool char_check, word_check;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> str;
		word_check = false;

		for (int j = 0; j < str.length(); j++) {
			check = str[j];
			char_check = false;

			for (int k = j + 1; k < str.length(); k++) {
				if (check != str[k]) {
					char_check = true;
					continue;
				}
				else if (char_check == true) {
					word_check = true;
					break;
				}
			}

			if (word_check == true) {
				not_group_word++;
				break;
			}
		}
	}
	cout << n - not_group_word;
}