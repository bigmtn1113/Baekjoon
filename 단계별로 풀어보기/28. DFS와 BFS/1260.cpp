#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> adjacent_vertex[1001];
bool is_visit[1001];
queue<int> q;
int n, m, v;

void Dfs(int vertex) {
	is_visit[vertex] = true;
	cout << vertex << ' ';

	for (int i = 0; i < adjacent_vertex[vertex].size(); ++i)
		if (!is_visit[adjacent_vertex[vertex][i]])
			Dfs(adjacent_vertex[vertex][i]);

	// ���̿켱Ž��
	// �а� Ž������ �ʰ� ��� Ž����

	// ex)
	// Dfs(1)	->	adjacent_vertex[1] = 2, 3, 4	->	2 �湮
	// Dfs(2)	->	adjacent_vertex[2] = 1, 4		->	1�� �̹� �湮������ 4 �湮
	// Dfs(4)	->	adjacent_vertex[4] = 1, 2, 3	->	1, 2�� �̹� �湮������ 3 �湮
	// Dfs(3)	->	adjacent_vertex[3] = 1, 4		->	1, 4�� �̹� �湮������ ����
	// ���: 1 2 4 3
}

void Bfs(int vertex) {
	int current;

	q.push(vertex);
	is_visit[vertex] = true;

	while (!q.empty()) {
		current = q.front();
		q.pop();

		cout << current << ' ';

		for (int i = 0; i < adjacent_vertex[current].size(); ++i)
			if (!is_visit[adjacent_vertex[current][i]]) {
				q.push(adjacent_vertex[current][i]);
				is_visit[adjacent_vertex[current][i]] = true;
			}
	}

	// �ʺ�켱Ž��
	// ��� Ž������ �ʰ� �а� Ž����

	// ex)
	// Bfs(1)	->	adjacent_vertex[1] = 2, 3, 4	->	1�� �湮������ ť���� ������ 2, 3, 4�� ť�� ����
	// Bfs(2)	->	adjacent_vertex[2] = 1, 4		->	2�� �湮������ ť���� ������ 4�� ť�� ������ �н�
	// Bfs(3)	->	adjacent_vertex[3] = 1, 4		->	3�� �湮������ ť���� ������ 4�� ť�� ������ �н�
	// Bfs(4)	->	adjacent_vertex[4] = 1, 2, 3	->	4�� �湮������ ť���� ������ 1, 2, 3�� �湮������ ����
	// ���: 1 2 3 4
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int vertex1, vertex2;

	cin >> n >> m >> v;
	for (int i = 0; i < m; ++i) {
		cin >> vertex1 >> vertex2;

		adjacent_vertex[vertex1].push_back(vertex2);
		adjacent_vertex[vertex2].push_back(vertex1);

		// ex) 1�� 2�� ���� = 2�� 1�� ����
	}

	for (int i = 1; i <= n; ++i)
		sort(adjacent_vertex[i].begin(), adjacent_vertex[i].end());

	Dfs(v);

	cout << '\n';
	fill_n(is_visit, n + 1, false);

	Bfs(v);
}