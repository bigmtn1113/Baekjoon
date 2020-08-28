#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> adjacent_v_e[20001];
priority_queue<pair<int, int>> pq;
int dist[20001];

void Dijkstra(int k) {
	// ���� ������ ���� ������ �Ÿ� = 0
	pq.push({ 0, k });
	dist[k] = 0;

	int current, current_weight, next, next_weight;

	while (!pq.empty()) {
		// �켱 ���� ť�� ���� ū ���� top�̱� ������ �״�� ������ ���� ����ġ�� ū ���� top�� ��
		// ���� -�� ������� ��
		current_weight = -pq.top().first;
		current = pq.top().second;
		pq.pop();

		// ť���� ���� ���� current�� �ּ� �Ÿ����� ũ�� �н�~
		if (dist[current] < current_weight)
			continue;

		// current�� ����� ������ ������ŭ �ݺ�
		for (int i = 0; i < adjacent_v_e[current].size(); ++i) {
			next = adjacent_v_e[current][i].first;
			next_weight = adjacent_v_e[current][i].second;

			// next�� �ּ� �Ÿ����� current�� ���ļ� ���� �Ÿ��� �� ª�� ���
			if (dist[next] > dist[current] + next_weight) {
				dist[next] = dist[current] + next_weight;
				pq.push({ -dist[next], next });
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int v, e, k;
	int from, to, weight;

	cin >> v >> e >> k;
	while (e--) {
		cin >> from >> to >> weight;
		adjacent_v_e[from].push_back({ to, weight });
	}

	fill_n(dist, v + 1, 0x7fffffff);
	Dijkstra(k);

	for (int i = 1; i <= v; ++i)
		dist[i] == 0x7fffffff ? cout << "INF" << '\n' : cout << dist[i] << '\n';
}