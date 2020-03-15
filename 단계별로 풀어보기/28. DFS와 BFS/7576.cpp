#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

queue<pair<int, int>> q;
int box[1001][1001];
int visit[1001][1001];
int direction[4][2] = { { 1, 0 },{ -1, 0 },{ 0, 1 },{ 0, -1 } };
int m, n, min_date;

void Bfs() {
	int current_x, current_y, next_x, next_y;

	while (!q.empty()) {
		current_x = q.front().first;
		current_y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; ++i) {
			next_x = current_x + direction[i][0];
			next_y = current_y + direction[i][1];

			if (next_x < 0 || next_y < 0 || next_x >= n || next_y >= m)
				continue;

			if (box[next_x][next_y] == 0 && !visit[next_x][next_y]) {
				q.push(make_pair(next_x, next_y));
				min_date = visit[next_x][next_y] = visit[current_x][current_y] + 1;
			}
		}
	}
}

bool CheckZero() {
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < m; ++j) {
			if (!box[i][j] && !visit[i][j])
				return false;
		}
	}
	return true;

	// Bfs 탐색했는데 토마토가 있는 곳의 값이 아직도 0이다?
	//	-> 이런.. 토마토가 모두 익지 않았구만
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int tomato_cnt = 0;

	cin >> m >> n;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < m; ++j) {
			cin >> box[i][j];
			if (box[i][j] == 1) {
				++tomato_cnt;

				q.push(make_pair(i, j));
				visit[i][j] = 1;
			}
		}

	// 익은 토마토가 없음
	if (!tomato_cnt)
		cout << -1;

	else {
		Bfs();

		if (!min_date) cout << 0;		// 이미 토마토가 다 익어있는 경우
		else CheckZero() ? cout << min_date - 1 : cout << -1;
	}
}