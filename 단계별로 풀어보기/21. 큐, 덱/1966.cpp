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

			// 최대값(중요도가 가장 높은 값) 및 최대값 인덱스 찾기
			for (int j = front; j < rear; j++)
				if (queue[j] > max) {
					max = queue[j];
					max_index = j;
				}

			// m에 해당하는 숫자가 최대값이 되어 출력할 차례가 되었을 때
			if (max_index == m) { cout << cnt + 1 << '\n'; break; }

			while (true) {
				// 덱의 맨 앞의 숫자가 최대값이 아니면 덱의 맨 뒤로 보냄.
				if (queue[front] != max) {
					Push(queue[front]);
					Pop();

					// m에 해당하는 숫자를 출력할 시점이 아니면 덱의 맨 뒤로 보냄.
					// m에 해당하는 숫자가 덱의 맨 뒤로 갔으니 m값을 변경.
					if (m == front - 1)
						m = rear - 1;
				}
				// 덱의 맨 앞의 숫자가 최대값이면 덱에서 제외하고 출력 카운트를 1증가 시킴.
				else {
					Pop();
					++cnt;
					break;
				}
			}
		}
	}
}