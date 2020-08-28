#include <iostream>
#include <string>

using namespace std;

int deque[100001];
int front, rear;
bool reverse_sw;

void Push(int num) { deque[rear++] = num; }
bool Pop() {
	if (front == rear) return false;

	// R이 홀수면 뒤에서 pop, 0이나 짝수면 앞에서 pop
	if (!reverse_sw) ++front;
	else --rear;
	return true;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, n;
	string command, arr, num;
	bool empty;

	cin >> t;
	for (int i = 0; i < t; i++) {
		front = rear = 0;
		reverse_sw = false;
		empty = false;
		num = "";

		cin >> command >> n >> arr;

		// 배열에서 숫자만 push
		for (int j = 1; j < arr.length() - 1; j++) {
			if (arr[j] != ',')
				num += arr[j];
			else {
				Push(stoi(num));
				num = "";
			}
		}
		if (num != "") Push(stoi(num));

		// reverse_sw 가 false면 앞에서 pop, true면 뒤에서 pop
		for (int j = 0; j < command.length(); j++) {
			if (command[j] == 'R')
				reverse_sw = reverse_sw == false ? true : false;

			else if (command[j] == 'D') {
				if (!Pop()) {
					empty = true;
					break;
				}
			}
		}

		if (empty) { cout << "error\n"; continue; }

		cout << "[";
		// 덱이 비어있으면 []출력, 비어있지 않으면 원소 출력
		if (front != rear) {
			// 뒤에서부터 출력
			if (reverse_sw) {
				for (int j = rear - 1; j > front; j--)
					cout << deque[j] << ",";
				cout << deque[front];
			}
			// 앞에서부터 출력
			else {
				for (int j = front; j < rear - 1; j++)
					cout << deque[j] << ",";
				cout << deque[rear - 1];
			}
		}
		cout << "]\n";
	}
}