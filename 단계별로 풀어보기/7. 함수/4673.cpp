#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, self_num[10000] = { 0 };
	string num;

	for (int i = 0; i < 10000; i++) {
		n = i;
		num = to_string(n);
		for (int j = 0; j < num.length(); j++)
			n += num[j] - '0';
		if (n < 10000)
			self_num[n]++;
	}
	for (int i = 0; i < 10000; i++)
		if (self_num[i] == 0)
			cout << i << '\n';
}