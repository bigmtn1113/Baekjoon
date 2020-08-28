#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> tree[10001];
bool visit[10001];
int far_node, far_node_dist;

void Dfs(int node, int dist) {
	visit[node] = true;

	if (far_node_dist < dist) {
		far_node_dist = dist;
		far_node = node;
	}

	for (int i = 0; i < tree[node].size(); ++i) {
		int next_node = tree[node][i].first;
		int next_dist = tree[node][i].second;

		if (!visit[next_node])
			Dfs(next_node, dist + next_dist);
	}
}

void Bfs(int begin) {
	queue<pair<int, int>> q;
	q.push({ begin, 0 });
	visit[begin] = true;

	while (!q.empty()) {
		int node = q.front().first;
		int dist = q.front().second;
		q.pop();

		if (far_node_dist < dist) {
			far_node_dist = dist;
			far_node = node;
		}

		for (int i = 0; i < tree[node].size(); ++i) {
			int next_node = tree[node][i].first;
			int next_dist = tree[node][i].second;

			if (!visit[next_node]) {
				q.push({ next_node, dist + next_dist });
				visit[next_node] = true;
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
		int node1, node2, dist;

		cin >> node1 >> node2 >> dist;
		tree[node1].push_back({ node2, dist });
		tree[node2].push_back({ node1, dist });
	}

	/*
		Dfs: 스택이 아닌 재귀라 Bfs에 비해 메모리가 더 들었으나 코드가 간단.
		Bfs: 재귀 Dfs에 비해 메모리가 적게 들었으나 코드는 김

		이 문제에선 Dfs, Bfs 통과 시간이 동일.
		하지만 데이터가 더 많아지면 메모리나 통과 시간에 대한 견해가 달라질 것 같음.
	*/

	// Dfs(1, 0);
	Bfs(1);			// 1과 가장 멀리 떨어진 정점 구하기

	fill_n(visit, 10001, false);
	far_node_dist = 0;

	// Dfs(far_node, 0);
	Bfs(far_node);			// far_node(1과 가장 멀리 떨어진 정점)와 가장 멀리 떨어진 정점 구하기
	cout << far_node_dist;		// far_node와 가장 멀리 떨어진 정점과의 거리 출력
}