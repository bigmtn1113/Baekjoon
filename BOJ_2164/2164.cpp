#include <iostream>

using namespace std;

int queue[1000001];
int front, rear;

void Push(int num) { queue[rear++] = num; }
int Pop() { return queue[front++]; }

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 1; i <= n; i++)
		Push(i);

	while (rear - front > 1) {
		Pop();
		Push(Pop());
	}
	cout << queue[front];
}