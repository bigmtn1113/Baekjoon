#include <iostream>
#include <queue>
#include <cstring>

using namespace std;

int direction_x[4] = { 1, 0, -1, 0 };
int direction_y[4] = { 0, 1, 0, -1 };
bool is_visit[51][51];
bool cabbage_field[51][51];
queue<pair<int, int>> q;

int width, height;

void Dfs(int y, int x) {
	is_visit[y][x] = true;

	int dx, dy;
	for (int i = 0; i < 4; ++i) {
		dx = x + direction_x[i];
		dy = y + direction_y[i];

		if (dx < 0 || dy < 0 || dx > width || dy > height) continue;
		if (cabbage_field[dy][dx] && !is_visit[dy][dx]) Dfs(dy, dx);
	}
}

void Bfs(int y, int x) {
	q.push(make_pair(y, x));
	is_visit[y][x] = true;

	int current_x, current_y, dx, dy;

	while (!q.empty()) {
		current_x = q.front().second;
		current_y = q.front().first;
		q.pop();

		for (int i = 0; i < 4; ++i) {
			dx = current_x + direction_x[i];
			dy = current_y + direction_y[i];

			if (dx < 0 || dy < 0 || dx > width || dy > height)
				continue;

			if (cabbage_field[dy][dx] && !is_visit[dy][dx]) {
				q.push(make_pair(dy, dx));
				is_visit[dy][dx] = true;
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, k, x, y, earthworm = 0;

	cin >> t;
	while (t--) {
		cin >> width >> height >> k;
		while (k--) {
			cin >> x >> y;
			cabbage_field[y][x] = true;
		}

		for (int i = 0; i < height; ++i)
			for (int j = 0; j < width; ++j)
				if (cabbage_field[i][j] && !is_visit[i][j]) {
					Dfs(i, j);
					// Bfs(i, j);
					++earthworm;
				}

		cout << earthworm << '\n';

		earthworm = 0;
		memset(cabbage_field, false, sizeof(cabbage_field));
		memset(is_visit, false, sizeof(is_visit));
	}
}