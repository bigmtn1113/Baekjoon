#include <iostream>
#include <queue>
#include <string>

using namespace std;

bool maze[101][101];
int is_visit[101][101];
int direction_x[4] = { 0, 1, 0, -1 };
int direction_y[4] = { 1, 0, -1, 0 };
int n, m;

queue<pair<int, int>> q;

void Bfs(int x, int y) {
	q.push(make_pair(x, y));
	is_visit[x][y] = true;

	int current_x, current_y, dx, dy;

	while (!q.empty()) {
		current_x = q.front().first;
		current_y = q.front().second;
		q.pop();

		for (int i = 0; i < 4; ++i) {
			dx = current_x + direction_x[i];
			dy = current_y + direction_y[i];

			if (dx < 0 || dy < 0 || dx > n - 1 || dy > m - 1)
				continue;

			if (maze[dx][dy] && !is_visit[dx][dy]) {
				q.push(make_pair(dx, dy));
				is_visit[dx][dy] = is_visit[current_x][current_y] + 1;
				// 다음 칸으로 갈때마다 현재 칸 값 + 1
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string maze_input;

	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> maze_input;
		for (int j = 0; j < m; ++j)
			maze[i][j] = maze_input[j] - '0';
	}

	Bfs(0, 0);
	cout << is_visit[n - 1][m - 1];
}