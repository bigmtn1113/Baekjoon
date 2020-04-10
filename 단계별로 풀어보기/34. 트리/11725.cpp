#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool visit[100001];			// 방문 여부 판단
int parent[100001];			// parent[a] = a의 부모노드
vector<int> tree[100001];

void Dfs(int node) {
	visit[node] = true;

	for (int i = 0; i < tree[node].size(); ++i) {
		int next = tree[node][i];

		if (!visit[next]) {
			parent[next] = node;		// next의 부모 노드는 node
			Dfs(next);
		}
	}
}

void Bfs(int root) {
	queue<int> q;
	q.push(root);
	visit[root] = true;

	while (!q.empty()) {
		int node = q.front();
		q.pop();

		for (int i = 0; i < tree[node].size(); ++i) {
			int next = tree[node][i];

			if (!visit[next]) {
				parent[next] = node;
				q.push(next);
				visit[next] = true;
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 0; i < n - 1; ++i) {
		int node1, node2;

		cin >> node1 >> node2;
		tree[node1].push_back(node2);
		tree[node2].push_back(node1);
	}

	/*
		Dfs: 스택으로 구현하면 Bfs보다 메모리가 더 적게 드나 재귀로 구현해서 메모리가 더 들음. 대신 코드는 간단.
		Bfs: 코드는 재귀 Dfs보다 길지만 재귀 Dfs보다 메모리를 더 적게 사용.

		이 문제에선 Dfs, Bfs 통과시간 동일했음.
	*/

	//Dfs(1);
	Bfs(1);

	for (int i = 2; i <= n; ++i)
		cout << parent[i] << '\n';
}