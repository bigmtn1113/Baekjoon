#include <iostream>
#include <string>

using namespace std;

char stack[101];
int top;

void Push(char ps) { stack[top++] = ps; }
char Pop() {
	if (top == 0) return '\0';
	else return stack[--top];
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string parenthesis_string;
	bool is_valid_pop;

	while (true) {
		top = 0;
		is_valid_pop = true;

		getline(cin, parenthesis_string);
		if (parenthesis_string == ".") break;

		for (int j = 0; j < parenthesis_string.length(); j++) {
			if (parenthesis_string[j] == '(' || parenthesis_string[j] == '[')
				Push(parenthesis_string[j]);
			else if (parenthesis_string[j] == ')') {
				if (Pop() != '(') { is_valid_pop = false; break; }
			}
			else if (parenthesis_string[j] == ']')
				if (Pop() != '[') { is_valid_pop = false; break; }
		}

		(!top && is_valid_pop) ? cout << "yes\n" : cout << "no\n";
	}
}