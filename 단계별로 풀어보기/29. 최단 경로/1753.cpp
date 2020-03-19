#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<pair<int, int>> adjacent_v_e[20001];
priority_queue<pair<int, int>> pq;
int dist[20001];

void Dijkstra(int k) {
	// 시작 지점과 시작 지점의 거리 = 0
	pq.push({ 0, k });
	dist[k] = 0;

	int current, current_weight, next, next_weight;

	while (!pq.empty()) {
		// 우선 순위 큐는 가장 큰 값이 top이기 때문에 그대로 넣으면 가장 가중치가 큰 값이 top이 됨
		// 따라서 -를 곱해줘야 함
		current_weight = -pq.top().first;
		current = pq.top().second;
		pq.pop();

		// 큐에서 꺼낸 값이 current의 최소 거리보다 크면 패스~
		if (dist[current] < current_weight)
			continue;

		// current와 연결된 정점의 개수만큼 반복
		for (int i = 0; i < adjacent_v_e[current].size(); ++i) {
			next = adjacent_v_e[current][i].first;
			next_weight = adjacent_v_e[current][i].second;

			// next의 최소 거리보다 current를 거쳐서 가는 거리가 더 짧을 경우
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