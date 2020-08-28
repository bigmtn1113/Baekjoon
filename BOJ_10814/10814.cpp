#include <iostream>
#include <cstdio>
#include <string>
#include <map>

using namespace std;

int main() {
	int n, age;
	string name;
	multimap<int, string> m;
	multimap<int, string>::iterator it;

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		cin >> age >> name;
		m.insert(make_pair(age, name));
	}

	for (it = m.begin(); it != m.end(); it++)
		cout << it->first << " " << it->second << "\n";
}