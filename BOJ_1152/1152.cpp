#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string str;
	char* c;
	int count = 0;

	getline(cin, str);
	c = new char[str.length()];
	strcpy(c, str.c_str());

	char *tok = strtok(c, " ");
	while (tok != nullptr) {
		count++;
		tok = strtok(nullptr, " ");
	}

	cout << count;
	delete c;
}

// memory: 4112KB
// time: 8ms

/*
#include <iostream>
#include <cstring>
#include <cstdio>

using namespace std;

int main() {
	char c[1000001];
	int count = 0;

	scanf("%[^\n]s", c);

	char *tok = strtok(c, " ");
	while (tok != nullptr) {
		count++;
		tok = strtok(nullptr, " ");
	}

	printf("%d", count);
}

// memory: 2840KB
// time: 12ms
*/