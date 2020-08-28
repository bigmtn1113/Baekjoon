#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> tree[100001];
bool visit[100001];
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

	int v;

	cin >> v;
	for (int i = 0; i < v; ++i) {
		int node1;

		cin >> node1;
		while (true) {
			int node2, dist;

			cin >> node2;
			if (node2 < 0) break;

			cin >> dist;
			tree[node1].push_back({ node2, dist });
		}
	}

	/*
		Dfs: Bfs�� ���� �޸𸮰� ���� ������� �ð��� �ణ �� ��
		Bfs: Dfs�� ���� �޸𸮰� �� ������� �ð��� �ణ ���� ��
	*/

	//Dfs(1, 0);
	Bfs(1);			// 1�� ���� �ָ� ������ ���� ���ϱ�

	fill_n(visit, 100001, false);
	far_node_dist = 0;

	//Dfs(far_node, 0);
	Bfs(far_node);			// far_node(1�� ���� �ָ� ������ ����)�� ���� �ָ� ������ ���� ���ϱ�
	cout << far_node_dist;		// far_node�� ���� �ָ� ������ �������� �Ÿ� ���
}