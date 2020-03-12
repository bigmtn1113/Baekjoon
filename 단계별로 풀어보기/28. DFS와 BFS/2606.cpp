#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> adjacent_vertex[1001];
bool is_visit[1001];
queue<int> q;
int n, m, cnt;

void Dfs(int vertex) {
	is_visit[vertex] = true;
	++cnt;

	for (int i = 0; i < adjacent_vertex[vertex].size(); ++i)
		if (!is_visit[adjacent_vertex[vertex][i]])
			Dfs(adjacent_vertex[vertex][i]);

	// ���̿켱Ž��
	// �а� Ž������ �ʰ� ��� Ž����

	// ex)
	// Dfs(1)	->	adjacent_vertex[1] = 2, 5	->	2 �湮
	// Dfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	1�� �̹� �湮������ 3 �湮
	// Dfs(3)	->	adjacent_vertex[3] = 2	->	2�� �̹� �湮�߰� �� �湮�� ���� ������ 2�� ����
	// Dfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	1, 3�� �̹� �湮������ 5 �湮
	// Dfs(5)	->	adjacent_vertex[5] = 1, 2, 6	->	1, 2�� �̹� �湮������ 6 �湮
	// Dfs(6)	->	adjacent_vertex[6] = 5	->	5�� �̹� �湮�߰� �� �湮�� ���� ������ 5�� ����
	// Dfs(5)	->	adjacent_vertex[5] = 1, 2, 6	->	1, 2, 6�� �̹� �湮�߰� �� �湮�� ���� ������ 2�� ����
	// Dfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	1, 3, 5�� �̹� �湮�߰� �� �湮�� ���� ������ 1�� ����
	// Dfs(1)	->	adjacent_vertex[1] = 2, 5	->	2, 5�� �̹� �湮�߰� �� �湮�� ���� ������ ����
	// ���: 1 2 3 5 6
}

void Bfs(int vertex) {
	int current;

	q.push(vertex);
	is_visit[vertex] = true;

	while (!q.empty()) {
		current = q.front();
		q.pop();

		++cnt;

		for (int i = 0; i < adjacent_vertex[current].size(); ++i)
			if (!is_visit[adjacent_vertex[current][i]]) {
				q.push(adjacent_vertex[current][i]);
				is_visit[adjacent_vertex[current][i]] = true;
			}
	}

	// �ʺ�켱Ž��
	// ��� Ž������ �ʰ� �а� Ž����

	// ex)
	// Bfs(1)	->	adjacent_vertex[1] = 2, 5	->	1�� �湮������ ť���� ������ 2, 5�� ť�� ����
	// Bfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	2�� �湮������ ť���� ������ 3�� ť�� ����. 1�� �̹� �湮�߰� 5�� ť�� ������ �н�
	// Bfs(5)	->	adjacent_vertex[5] = 1, 2, 6	->	5�� �湮������ ť���� ������ 6�� ť�� ����. 1, 2�� �̹� �湮������ �н�
	// Bfs(3)	->	adjacent_vertex[3] = 2	->	3�� �湮������ ť���� ������ �� �湮�� �� ������ �н�
	// Bfs(6)	->	adjacent_vertex[6] = 5	->	6�� �湮������ ť���� ������ �� �湮�� �� ������ �н�
	
	// ť�� ��ȭ: 1 -> 2 5 -> 5 3 -> 3 6 -> 6 -> empty
	// ���: 1 2 5 3 6
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int vertex1, vertex2;

	cin >> n >> m;
	for (int i = 0; i < m; ++i) {
		cin >> vertex1 >> vertex2;

		adjacent_vertex[vertex1].push_back(vertex2);
		adjacent_vertex[vertex2].push_back(vertex1);

		// ex) 1�� 2�� ���� = 2�� 1�� ����
	}

	Dfs(1);
	// Bfs(1);

	cout << cnt - 1;
}