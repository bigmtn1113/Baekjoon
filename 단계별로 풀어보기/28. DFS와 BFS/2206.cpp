#include <iostream>
#include <queue>
#include <string>

using namespace std;

int map[1001][1001];
int visit[1001][1001][2];
int direction[4][2] = { { 1, 0 },{ -1, 0 },{ 0, 1 },{ 0, -1 } };
int n, m;

struct xyz { int x, y, wall; };

int Bfs() {
	queue<xyz> q;
	q.push({ 0, 0, 0 });
	visit[0][0][0] = 1;

	int x, y, wall, next_x, next_y;

	while (!q.empty()) {
		x = q.front().x;
		y = q.front().y;
		wall = q.front().wall;
		q.pop();

		if (x == n - 1 && y == m - 1)
			return visit[x][y][wall];

		for (int i = 0; i < 4; ++i) {
			next_x = x + direction[i][0];
			next_y = y + direction[i][1];

			if (next_x < 0 || next_y < 0 || next_x > n - 1 || next_y > m - 1 || visit[next_x][next_y][wall])
				continue;

			if (!map[next_x][next_y]) {
				q.push({ next_x, next_y, wall });
				visit[next_x][next_y][wall] = visit[x][y][wall] + 1;
			}

			else if (!wall) {
				q.push({ next_x, next_y, 1 });
				visit[next_x][next_y][1] = visit[x][y][wall] + 1;
			}
		}
	}

	return -1;

	// ���� �� ���� �� �μ��� ���� vs ���� �� �� �μ��� ����
	// � ���� �� �Ÿ��� ª����?

	// ���� �������� �̹� �湮�� ���̴�?	-> ����~ �� ��
	// ���� �������� ���� ��� �׳� �� �� �ִ� ���̰� �湮�� ���� ����?	->	������ ����~
	// ���� �������� ���� �����ְ� ������� ���鼭 ���� �μ� ���� ����?	->	�μ������� ����~ �� �ڻ������ ǥ���ؾ߰ڱ�

	// ���� �μ� ���� �ִ��� Ȯ��	->	visit[x][y][0], visit[x][y][1]: 0�̸� �� �μ� ���̰� 1�̸� �μ� ��
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string input_map;

	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> input_map;
		for (int j = 0; j < m; ++j)
			map[i][j] = input_map[j] - '0';
	}

	cout << Bfs();
}