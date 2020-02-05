#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

int main() {
	int n, num_place, count = 0;
	string num;
	bool is_increase;

	scanf("%d", &n);
	for (int i = 666;; i++) {
		num = to_string(i);
		num_place = num.length();
		is_increase = false;

		for (int j = 0; j < num_place - 2; j++)
			if (num[j] == '6' && num[j + 1] == '6' && num[j + 2] == '6') {
				if (!is_increase && (++count == n)) {
					printf("%d", i);
					return 0;
				}
				is_increase = true;
			}
	}
}