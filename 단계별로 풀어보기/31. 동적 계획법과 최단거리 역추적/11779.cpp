#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<pair<int, int>> adj[1001];
int dist[1001];
int pre_city[1001];			// ���� ����

void Dijkstra(int begin) {
	priority_queue<pair<int, int>> pq;		// �켱���� ť. �⺻������ ���� ū ���� top�̱� ������ �ּڰ��� top�̷��� -�� ���̰� �ְ� ������
	pq.push({ 0, begin });		// ���� ���� ť�� �ֱ�
	dist[begin] = 0;			// ���� ������ ����� 0

	while (!pq.empty()) {
		int cost = -pq.top().first;		// ���� �ִ� ���ñ��� ���µ� ��� ���
		int city = pq.top().second;		// ���� �ִ� ����
		pq.pop();

		if (dist[city] < cost)			// ���� �ִ� ���ñ��� ���µ� ��� �ּ� ��뺸�� cost�� ũ�� �н�~
			continue;

		for (int i = 0; i < adj[city].size(); ++i) {
			int next_city = adj[city][i].first;			// ���� ����
			int next_cost = adj[city][i].second;		// ���� ���ð��µ� ��� ���

			if (dist[next_city] > dist[city] + next_cost) {		// ���� ���ð��µ� ��� �ּ� ��뺸�� ���� �ִ� ���ø� ���İ��� ����� �� �������
				dist[next_city] = cost + next_cost;
				pq.push({ -dist[next_city], next_city });
				pre_city[next_city] = city;						// ���� ���÷� ���� ���� ���� �ִ� ���� ����
			}
		}

	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, m;

	cin >> n >> m;
	while (m--) {
		int src, dest, cost;

		cin >> src >> dest >> cost;
		adj[src].push_back({ dest, cost });
	}

	fill_n(dist, n + 1, 987654321);

	int begin, end;

	cin >> begin >> end;
	Dijkstra(begin);
	cout << dist[end] << '\n';

	vector<int> result;
	int cnt = 1;

	/*
		ex) 1 5
		1 -> 4 -> 5

		end = 5 -> pre_city[5] = 4
		end = 4 -> pre_city[4] = 1
	*/

	result.push_back(end);
	while (end != begin) {
		end = pre_city[end];
		result.push_back(end);

		++cnt;
	}

	cout << cnt << '\n';
	for (int i = result.size() - 1; i >= 0; --i)		// �Ųٷ� ���
		cout << result[i] << ' ';
}