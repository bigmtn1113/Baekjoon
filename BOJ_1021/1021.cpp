#include <iostream>

using namespace std;

int deque[1001];
int front = 1, rear = 1;

void PushBack(int num) { deque[rear++] = num; }
int PopFront() { return deque[front++]; }
int PopBack() { return deque[--rear]; }

void PushFront(int num) {
	int temp_rear = rear;

	// ���� �ִ� ������ �� ĭ�� �ڷ� �̵�.
	while (rear > 0) {
		PushBack(deque[rear - 1]);
		rear -= 2;
	}

	// ���� �� �տ� num ����.
	deque[front] = num;
	rear = temp_rear + 1;
}


int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, m, position;
	int position_index;
	int two_cnt = 0, three_cnt = 0;

	cin >> n >> m;
	for (int i = 1; i <= n; i++)
		PushBack(i);

	for (int i = 0; i < m; i++) {
		cin >> position;

		while (true) {
			if (deque[front] == position) {
				PopFront();
				break;
			}

			// �̾Ƴ����� �ϴ� �� ��ġ ã��
			int temp = 1;
			for (int j = front; j < rear; j++) {
				if (position == deque[j]) position_index = temp;
				++temp;
			}

			// �̾Ƴ����� �ϴ� ���� ��ġ�� ���ʿ� ���� �� �������� �̵�.
			if ((rear - front) / 2 + 1 >= position_index) {
				two_cnt++;
				PushBack(PopFront());
			}
			// �̾Ƴ����� �ϴ� ���� ��ġ�� ���ʿ� ���� �� ���������� �̵�.
			else {
				three_cnt++;
				PushFront(PopBack());
			}
		}
	}

	cout << two_cnt + three_cnt;
}