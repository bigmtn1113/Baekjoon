#include <iostream>
#include <vector>
#include <queue>
#define MIN(X, Y) ((X < Y) ? (X) : (Y))
#define INF 0x7fffffff

using namespace std;

vector<pair<int, int>> adjacent_v_e[801];
int dist[801];
int v;

void Dijkstra(int src) {
	priority_queue<pair<int, int>> pq;

	fill_n(dist, v + 1, INF);
	pq.push({ 0, src });
	dist[src] = 0;

	int current, current_weight, next, next_weight;

	while (!pq.empty()) {
		current_weight = -pq.top().first;
		current = pq.top().second;
		pq.pop();

		if (dist[current] < current_weight)
			continue;

		for (int i = 0; i < adjacent_v_e[current].size(); ++i) {
			next = adjacent_v_e[current][i].first;
			next_weight = adjacent_v_e[current][i].second;

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

	int e, must_pass[2];
	int vertex_a, vertex_b, weight;
	long long result[6], answer;

	cin >> v >> e;
	while (e--) {
		cin >> vertex_a >> vertex_b >> weight;
		adjacent_v_e[vertex_a].push_back({ vertex_b, weight });
		adjacent_v_e[vertex_b].push_back({ vertex_a, weight });
	}

	cin >> must_pass[0] >> must_pass[1];

	// 두 경로 중 더 짧은 경로가 답
	// 1 -> must_pass[0] -> must_pass[1] -> 마지막: a루트
	// 1 -> must_pass[1] -> must_pass[0] -> 마지막: b루트

	// 1 ~ must_pass[0]까지의 최단거리: a루트
	// 1 ~ must_pass[1]까지의 최단거리: b루트
	Dijkstra(1);
	result[0] = dist[must_pass[0]];
	result[1] = dist[must_pass[1]];

	// must_pass[0] ~ must_pass[1]까지의 최단거리: a루트
	// must_pass[0] ~ 마지막 정점까지의 최단거리: b루트
	Dijkstra(must_pass[0]);
	result[2] = dist[must_pass[1]];
	result[3] = dist[v];

	// must_pass[1] ~ 마지막 정점까지의 최단거리: a루트
	// must_pass[1] ~ must_pass[0]까지의 최단거리: b루트
	Dijkstra(must_pass[1]);
	result[4] = dist[v];
	result[5] = dist[must_pass[0]];

	// must_pass를 안 지날경우나 마지막 정점까지 갈 수 없는 경우엔 -1
	answer = MIN(result[0] + result[2] + result[4], result[1] + result[3] + result[5]);
	if (answer >= INF || answer < 0) cout << -1;
	else cout << answer;
}