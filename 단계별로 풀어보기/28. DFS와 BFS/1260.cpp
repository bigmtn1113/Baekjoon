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

	// 깊이우선탐색
	// 넓게 탐색하지 않고 깊게 탐색함

	// ex)
	// Dfs(1)	->	adjacent_vertex[1] = 2, 3, 4	->	2 방문
	// Dfs(2)	->	adjacent_vertex[2] = 1, 4		->	1은 이미 방문했으니 4 방문
	// Dfs(4)	->	adjacent_vertex[4] = 1, 2, 3	->	1, 2는 이미 방문했으니 3 방문
	// Dfs(3)	->	adjacent_vertex[3] = 1, 4		->	1, 4는 이미 방문했으니 종료
	// 결과: 1 2 4 3
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

	// 너비우선탐색
	// 깊게 탐색하지 않고 넓게 탐색함

	// ex)
	// Bfs(1)	->	adjacent_vertex[1] = 2, 3, 4	->	1은 방문했으니 큐에서 빠지고 2, 3, 4를 큐에 저장
	// Bfs(2)	->	adjacent_vertex[2] = 1, 4		->	2는 방문했으니 큐에서 빠지고 4는 큐에 있으니 패스
	// Bfs(3)	->	adjacent_vertex[3] = 1, 4		->	3은 방문했으니 큐에서 빠지고 4는 큐에 있으니 패스
	// Bfs(4)	->	adjacent_vertex[4] = 1, 2, 3	->	4는 방문했으니 큐에서 빠지고 1, 2, 3은 방문했으니 종료
	// 결과: 1 2 3 4
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

		// ex) 1과 2의 연결 = 2와 1의 연결
	}

	for (int i = 1; i <= n; ++i)
		sort(adjacent_vertex[i].begin(), adjacent_vertex[i].end());

	Dfs(v);

	cout << '\n';
	fill_n(is_visit, n + 1, false);

	Bfs(v);
}