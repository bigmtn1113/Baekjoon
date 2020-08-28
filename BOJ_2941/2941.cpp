#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string alphabet[8] = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
	string str, temp;
	int word_check = 0, word_count = 0;
	bool find = false;

	cin >> str;
	for (int i = 0; i < str.length(); i++) {
		temp += str[i];
		word_check++;

		if (word_check == 3) {
			word_check = 0;
			for (int j = 0; j < 8; j++)
				if (temp == alphabet[j]) {
					word_count++;
					find = true;
					break;
				}

			if (!find) {
				temp.erase(2, 1);
				for (int j = 0; j < 8; j++)
					if (temp == alphabet[j]) {
						word_count++;
						i -= 1;
						find = true;
						break;
					}
			}

			if (!find) {
				word_count++;
				i -= 2;
			}

			temp = "";
			find = false;
		}
	}
	if (word_check == 2) {
		word_check = 0;
		for (int j = 0; j < 8; j++)
			if (temp == alphabet[j]) {
				word_count++;
				find = true;
				break;
			}

		if (!find)
			word_count += 2;
	}
	if (word_check == 1)
		word_count++;

	cout << word_count;
}