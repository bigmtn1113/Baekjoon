#include <iostream>
#include <string>

using namespace std;

int stack[10001];
int top = 0;

void Push(int num) { stack[top++] = num; }
int Pop() { return top == 0 ? -1 : stack[--top]; }
int Size() { return top; }
int Empty() { return top == 0 ? 1 : 0; }
int Top() { return top == 0 ? -1 : stack[top - 1]; }

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input_num;
	string command;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> command;

		if (command == "push") { cin >> input_num; Push(input_num); }
		else if (command == "pop") cout << Pop() << '\n';
		else if (command == "size") cout << Size() << '\n';
		else if (command == "empty") cout << Empty() << '\n';
		else cout << Top() << '\n';
	}
}