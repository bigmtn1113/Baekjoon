#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

int main() {
	string n, constructor;
	int n_to_int, constructor_sum;
	bool is_find = false;

	cin >> n;
	n_to_int = stoi(n);

	for (int i = 0; i < n_to_int; i++) {
		constructor = to_string(i);
		constructor_sum = 0;
		is_find = false;

		for (int j = 0; j < constructor.length(); j++)
			constructor_sum += constructor[j] - '0';

		if (n_to_int == i + constructor_sum) {
			printf("%d", i);
			is_find = true;
			break;
		}
	}

	if (!is_find) printf("0");
}