#include <iostream>

using namespace std;

int main() {
	int input[5];
	int min_burger = 2001, min_juice = 2001;

	for (int i = 0; i < 5; ++i) {
		cin >> input[i];

		if (i < 3 && input[i] < min_burger) min_burger = input[i];
		if (i > 2 && input[i] < min_juice) min_juice = input[i];
	}

	cout << min_burger + min_juice - 50;
}