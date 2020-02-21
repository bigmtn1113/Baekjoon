#include <iostream>
#include <string>

using namespace std;

int queue[2000001];
int front, rear;

void Push(int num) { queue[rear++] = num; }
int Pop() { return front != rear ? queue[front++] : -1; }
int Size() { return rear - front; }
int Empty() { return front == rear ? 1 : 0; }
int Front() { return front != rear ? queue[front] : -1; }
int Back() { return front != rear ? queue[rear - 1] : -1; }

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
		else if (command == "front") cout << Front() << '\n';
		else if (command == "back") cout << Back() << '\n';
	}
}