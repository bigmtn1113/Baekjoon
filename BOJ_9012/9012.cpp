#include <iostream>
#include <string>

using namespace std;

int stack[51];
int top;

void Push() { ++top; }
bool Pop() {
	if (top == 0) return false;
	else { --top; return true; }
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t;
	string parenthesis_string;
	bool is_valid_pop;

	cin >> t;
	for (int i = 0; i < t; i++) {
		top = 0;
		is_valid_pop = true;

		cin >> parenthesis_string;

		for (int j = 0; j < parenthesis_string.length(); j++) {
			if (parenthesis_string[j] == '(') { Push(); continue; }
			if (!Pop()) { is_valid_pop = false; break; }
		}

		(!top && is_valid_pop) ? cout << "YES\n" : cout << "NO\n";
	}
}