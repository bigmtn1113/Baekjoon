#include <iostream>
#include <string>

using namespace std;

int deque[10001];
int front, rear;

void PushBack(int num) { deque[rear++] = num; }
int PopFront() { return front != rear ? deque[front++] : -1; }
int PopBack() { return front != rear ? deque[--rear] : -1; }
int Size() { return rear - front; }
int Empty() { return front != rear ? 0 : 1; }
int Front() { return front != rear ? deque[front] : -1; }
int Back() { return front != rear ? deque[rear - 1] : -1; }

void PushFront(int num) {
	int temp_rear = rear;

	while (rear > 0) {
		PushBack(Back());
		rear -= 2;
	}

	deque[front] = num;
	rear = temp_rear + 1;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input_num;
	string command;

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> command;

		if (command == "push_front") { cin >> input_num; PushFront(input_num); }
		else if (command == "push_back") { cin >> input_num; PushBack(input_num); }
		else if (command == "pop_front") { cout << PopFront() << '\n'; }
		else if (command == "pop_back") { cout << PopBack() << '\n'; }
		else if (command == "size") { cout << Size() << '\n'; }
		else if (command == "empty") { cout << Empty() << '\n'; }
		else if (command == "front") { cout << Front() << '\n'; }
		else if (command == "back") { cout << Back() << '\n'; }
	}
}