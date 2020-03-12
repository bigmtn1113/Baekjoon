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

	// 깊이우선탐색
	// 넓게 탐색하지 않고 깊게 탐색함

	// ex)
	// Dfs(1)	->	adjacent_vertex[1] = 2, 5	->	2 방문
	// Dfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	1은 이미 방문했으니 3 방문
	// Dfs(3)	->	adjacent_vertex[3] = 2	->	2는 이미 방문했고 더 방문할 곳이 없으니 2로 리턴
	// Dfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	1, 3은 이미 방문했으니 5 방문
	// Dfs(5)	->	adjacent_vertex[5] = 1, 2, 6	->	1, 2은 이미 방문했으니 6 방문
	// Dfs(6)	->	adjacent_vertex[6] = 5	->	5는 이미 방문했고 더 방문할 곳이 없으니 5로 리턴
	// Dfs(5)	->	adjacent_vertex[5] = 1, 2, 6	->	1, 2, 6은 이미 방문했고 더 방문할 곳이 없으니 2로 리턴
	// Dfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	1, 3, 5는 이미 방문했고 더 방문할 곳이 없으니 1로 리턴
	// Dfs(1)	->	adjacent_vertex[1] = 2, 5	->	2, 5는 이미 방문했고 더 방문할 곳이 없으니 종료
	// 결과: 1 2 3 5 6
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

	// 너비우선탐색
	// 깊게 탐색하지 않고 넓게 탐색함

	// ex)
	// Bfs(1)	->	adjacent_vertex[1] = 2, 5	->	1은 방문했으니 큐에서 빠지고 2, 5를 큐에 저장
	// Bfs(2)	->	adjacent_vertex[2] = 1, 3, 5	->	2는 방문했으니 큐에서 빠지고 3을 큐에 저장. 1은 이미 방문했고 5는 큐에 있으니 패스
	// Bfs(5)	->	adjacent_vertex[5] = 1, 2, 6	->	5는 방문했으니 큐에서 빠지고 6을 큐에 저장. 1, 2는 이미 방문했으니 패스
	// Bfs(3)	->	adjacent_vertex[3] = 2	->	3는 방문했으니 큐에서 빠지고 더 방문할 곳 없으니 패스
	// Bfs(6)	->	adjacent_vertex[6] = 5	->	6는 방문했으니 큐에서 빠지고 더 방문할 곳 없으니 패스
	
	// 큐의 변화: 1 -> 2 5 -> 5 3 -> 3 6 -> 6 -> empty
	// 결과: 1 2 5 3 6
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

		// ex) 1과 2의 연결 = 2와 1의 연결
	}

	Dfs(1);
	// Bfs(1);

	cout << cnt - 1;
}