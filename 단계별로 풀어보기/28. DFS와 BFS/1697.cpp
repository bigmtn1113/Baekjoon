#include <iostream>
#include <queue>

using namespace std;

queue<int> q;
int visit[100001];
int n, k;

void Bfs(int x) {
	q.push(x);
	visit[x] = 1;

	int current, next[3];
	while (!q.empty()) {
		current = q.front();
		q.pop();

		if (current == k)
			break;

		next[0] = current - 1;		// 뒤로 한 칸
		next[1] = current + 1;		// 앞으로 한 칸
		next[2] = current * 2;		// 순간이도오옹!

		for (int i = 0; i < 3; ++i) {
			if (next[i] < 0 || next[i] > 100000 || next[i] > 100000)
				continue;

			if (!visit[next[i]]) {
				q.push(next[i]);
				visit[next[i]] = visit[current] + 1;
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> k;

	Bfs(n);

	cout << visit[k] - 1;
}