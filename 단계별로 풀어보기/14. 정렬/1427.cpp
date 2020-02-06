#include <iostream>
#include <cstdio>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	string str;

	cin >> str;
	sort(&str[0], &str[str.length()], greater<int>());
	for (int i = 0; i < str.length(); i++)
		printf("%c", str[i]);
}