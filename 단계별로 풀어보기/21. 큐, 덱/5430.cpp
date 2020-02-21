#include <iostream>
#include <string>

using namespace std;

int deque[100001];
int front, rear;
bool reverse_sw;

void Push(int num) { deque[rear++] = num; }
bool Pop() {
	if (front == rear) return false;

	// R�� Ȧ���� �ڿ��� pop, 0�̳� ¦���� �տ��� pop
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

		// �迭���� ���ڸ� push
		for (int j = 1; j < arr.length() - 1; j++) {
			if (arr[j] != ',')
				num += arr[j];
			else {
				Push(stoi(num));
				num = "";
			}
		}
		if (num != "") Push(stoi(num));

		// reverse_sw �� false�� �տ��� pop, true�� �ڿ��� pop
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
		// ���� ��������� []���, ������� ������ ���� ���
		if (front != rear) {
			// �ڿ������� ���
			if (reverse_sw) {
				for (int j = rear - 1; j > front; j--)
					cout << deque[j] << ",";
				cout << deque[front];
			}
			// �տ������� ���
			else {
				for (int j = front; j < rear - 1; j++)
					cout << deque[j] << ",";
				cout << deque[rear - 1];
			}
		}
		cout << "]\n";
	}
}