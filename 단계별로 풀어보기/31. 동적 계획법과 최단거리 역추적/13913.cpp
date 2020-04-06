#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int dist[100001];
int pre_position[100001];		// 이전 위치 저장

void Bfs(int n, int k) {
	queue<int> q;
	q.push(n);
	dist[n] = 1;

	while (!q.empty()) {
		int current = q.front();
		q.pop();

		if (current == k)
			break;

		int next[3] = { current - 1, current + 1, current * 2 };
		for (int i = 0; i < 3; ++i) {
			if (next[i] < 0 || next[i] > 100000)
				continue;

			if (!dist[next[i]]) {
				q.push(next[i]);
				dist[next[i]] = dist[current] + 1;
				pre_position[next[i]] = current;		// 이전 위치 저장
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, k;
	vector<int> result;

	cin >> n >> k;
	Bfs(n, k);
	cout << dist[k] - 1 << '\n';

	/*
		ex) 5 17
		5 -> 4 -> 8 -> 16 -> 17
	
		k = 17 -> pre_positino[17] = 16
		k = 16 -> pre_positino[16] = 8
		k = 8 -> pre_positino[8] = 4
		k = 4 -> pre_positino[4] = 5
	*/
	result.push_back(k);
	while (k != n) {
		k = pre_position[k];
		result.push_back(k);
	}

	// 거꾸로 출력
	for (int i = result.size() - 1; i >= 0; --i)
		cout << result[i] << ' ';
}