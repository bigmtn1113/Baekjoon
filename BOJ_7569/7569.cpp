#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

queue<tuple<int, int, int>> q;
int box[101][101][101];
int is_visit[101][101][101];
int direction[6][3] = { { 1, 0, 0 },{ -1, 0, 0 },{ 0, 1, 0 },{ 0, -1, 0 },{ 0, 0, 1 },{ 0, 0, -1 } };
int m, n, h, min_date;

void Bfs() {
	int current[3], next[3];

	while (!q.empty()) {
		current[0] = get<0>(q.front());
		current[1] = get<1>(q.front());
		current[2] = get<2>(q.front());
		q.pop();

		for (int i = 0; i < 6; ++i) {
			next[0] = current[0] + direction[i][0];
			next[1] = current[1] + direction[i][1];
			next[2] = current[2] + direction[i][2];

			if (next[0] < 0 || next[1] < 0 || next[2] < 0 || next[0] >= h || next[1] >= n || next[2] >= m)
				continue;

			if (box[next[0]][next[1]][next[2]] == 0 && !is_visit[next[0]][next[1]][next[2]]) {
				q.push(make_tuple(next[0], next[1], next[2]));
				min_date = is_visit[next[0]][next[1]][next[2]] = is_visit[current[0]][current[1]][current[2]] + 1;
			}
		}
	}
}

bool CheckZero() {
	for (int i = 0; i < h; ++i) {
		for (int j = 0; j < n; ++j) {
			for (int k = 0; k < m; ++k) {
				if (!box[i][j][k] && !is_visit[i][j][k])
					return false;
			}
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

	cin >> m >> n >> h;
	for (int i = 0; i < h; ++i) {
		for (int j = 0; j < n; ++j)
			for (int k = 0; k < m; ++k) {
				cin >> box[i][j][k];
				if (box[i][j][k] == 1) {
					++tomato_cnt;

					q.push(make_tuple(i, j, k));
					is_visit[i][j][k] = 1;
				}
			}
	}

	if (!tomato_cnt)		// 익은 토마토가 없음
		cout << -1;

	else {
		Bfs();

		if (!min_date) cout << 0;		// 이미 토마토가 다 익어있는 경우
		else CheckZero() ? cout << min_date - 1 : cout << -1;
	}
}