#include <iostream>

using namespace std;

int queue[1001];
int front, rear;

void Push(int num) { queue[rear++] = num; }
void Pop() { ++front; }

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, n, m, priority;
	int max, max_index, cnt;

	cin >> t;
	for (int i = 0; i < t; i++) {
		front = rear = 0;
		cnt = 0;

		cin >> n >> m;
		for (int j = 0; j < n; j++) {
			cin >> priority;
			Push(priority);
		}

		while (true) {
			max = max_index = 0;

			// �ִ밪(�߿䵵�� ���� ���� ��) �� �ִ밪 �ε��� ã��
			for (int j = front; j < rear; j++)
				if (queue[j] > max) {
					max = queue[j];
					max_index = j;
				}

			// m�� �ش��ϴ� ���ڰ� �ִ밪�� �Ǿ� ����� ���ʰ� �Ǿ��� ��
			if (max_index == m) { cout << cnt + 1 << '\n'; break; }

			while (true) {
				// ���� �� ���� ���ڰ� �ִ밪�� �ƴϸ� ���� �� �ڷ� ����.
				if (queue[front] != max) {
					Push(queue[front]);
					Pop();

					// m�� �ش��ϴ� ���ڸ� ����� ������ �ƴϸ� ���� �� �ڷ� ����.
					// m�� �ش��ϴ� ���ڰ� ���� �� �ڷ� ������ m���� ����.
					if (m == front - 1)
						m = rear - 1;
				}
				// ���� �� ���� ���ڰ� �ִ밪�̸� ������ �����ϰ� ��� ī��Ʈ�� 1���� ��Ŵ.
				else {
					Pop();
					++cnt;
					break;
				}
			}
		}
	}
}