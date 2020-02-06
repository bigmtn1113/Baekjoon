#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

bool compare(const string &s1, const string &s2) {
	if (s1.length() < s2.length()) return true;
	else if (s1.length() == s2.length()) return s1 < s2;
	else return false;
}

int main() {
	int n;
	string dict[20001], temp;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		cin >> dict[i];

	sort(dict, dict + n, compare);

	cout << dict[0] << '\n';
	for (int i = 1; i < n; i++) {
		temp = dict[i];
		if (temp != dict[i - 1])
			cout << dict[i] << '\n';
	}
}