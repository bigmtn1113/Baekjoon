#include <iostream>
#include <vector>
#include <queue>
#include <tuple>

#define INF 987654321

using namespace std;

vector<tuple<int, int, int>> adjacent_v_e[101];
int dist[101][10001];		// dist[a][b]: a에서 b의 비용으로 갈 수 있는 최단 거리

int Dijkstra(int n, int m) {
	priority_queue<tuple<int, int, int>> pq;

	for (int i = 1; i <= n; ++i)
		for (int j = 1; j <= m; ++j)
			dist[i][j] = INF;

	pq.push({ 0, 1, 0 });		// weight, airport, cost
	dist[1][0] = 0;

	int current, current_weight, current_cost, next, next_weight, next_cost;
	while (!pq.empty()) {
		current_weight = -get<0>(pq.top());
		current = get<1>(pq.top());
		current_cost = get<2>(pq.top());
		pq.pop();

		if (dist[current][current_cost] < current_weight) continue;

		if (current == n) return current_weight;

		for (int i = 0; i < adjacent_v_e[current].size(); ++i) {
			next = get<0>(adjacent_v_e[current][i]);
			next_cost = get<1>(adjacent_v_e[current][i]);
			next_weight = get<2>(adjacent_v_e[current][i]);

			if (current_cost + next_cost > m) continue;

			if (dist[next][current_cost + next_cost] > current_weight + next_weight) {
				dist[next][current_cost + next_cost] = current_weight + next_weight;
				pq.push({ -dist[next][current_cost + next_cost], next, current_cost + next_cost });
			}
		}
	}

	return INF;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, n, m, k, u, v, c, d, result;

	cin >> t;
	while (t--) {
		cin >> n >> m >> k;
		while (k--) {
			cin >> u >> v >> c >> d;
			adjacent_v_e[u].push_back({ v, c, d });
		}

		result = Dijkstra(n, m);
		result == INF ? cout << "Poor KCM\n" : cout << result << '\n';

		for (int i = 1; i <= n; ++i)
			adjacent_v_e[i].clear();
	}
}