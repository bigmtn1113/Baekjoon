#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool visit[100001];			// �湮 ���� �Ǵ�
int parent[100001];			// parent[a] = a�� �θ���
vector<int> tree[100001];

void Dfs(int node) {
	visit[node] = true;

	for (int i = 0; i < tree[node].size(); ++i) {
		int next = tree[node][i];

		if (!visit[next]) {
			parent[next] = node;		// next�� �θ� ���� node
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
		Dfs: �������� �����ϸ� Bfs���� �޸𸮰� �� ���� �峪 ��ͷ� �����ؼ� �޸𸮰� �� ����. ��� �ڵ�� ����.
		Bfs: �ڵ�� ��� Dfs���� ������ ��� Dfs���� �޸𸮸� �� ���� ���.

		�� �������� Dfs, Bfs ����ð� ��������.
	*/

	//Dfs(1);
	Bfs(1);

	for (int i = 2; i <= n; ++i)
		cout << parent[i] << '\n';
}