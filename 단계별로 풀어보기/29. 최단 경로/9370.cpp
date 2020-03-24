#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

#define MIN(X, Y) ((X < Y) ? (X) : (Y))
#define INF 0x7fffffff

using namespace std;

vector<pair<int, int>> adjacent_v_e[2001];
int dist[2001];
int n;

void Dijkstra(int src) {
	priority_queue<pair<int, int>> pq;

	fill_n(dist, n + 1, INF);
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

	int test;
	int m, t, s, g, h, a, b, d;
	int temp[4], dest[101], dest_dist[303], answer_g[101], answer_h[101], answer[101];

	cin >> test;
	while (test--) {
		cin >> n >> m >> t;
		cin >> s >> g >> h;

		while (m--) {
			cin >> a >> b >> d;

			adjacent_v_e[a].push_back({ b, d });
			adjacent_v_e[b].push_back({ a, d });
		}

		for (int i = 0; i < t; ++i)
			cin >> dest[i];
		
		// 목적지 후보 오름차순 정렬 출력을 위한 정렬
		sort(dest, dest + t);

		// 서커스 예술가 한 쌍은 목적지까지 최단거리로 이동할 것이고, g와 h 교차로 사이에 있는 도로를 지나갔다?
		// -> g와 h 교차로 사이에 있는 도로를 지나는 것이 최단경로겠군.

		// 그럼 g를 먼저 지나는게 최단경로일까? h를 먼저 지나는게 최단경로일까?
		// -> 둘 중 더 짧은 쪽이 답이겠네.

		// s -> g -> h -> 목적지: g 경로
		// s -> h -> g -> 목적지: h 경로

		Dijkstra(s);
		temp[0] = dist[g];		// g 경로
		temp[1] = dist[h];		// h 경로

		// s -> 목적지까지의 최단경로
		// g 경로랑 h 경로 중 어느쪽이 최단경로인지 비교하기 위해
		for (int i = 0; i < t; ++i)
			dest_dist[i] = dist[dest[i]];

		Dijkstra(g);
		temp[2] = dist[h];

		// g -> 목적지까지의 최단경로
		for (int i = 0; i < t; ++i)
			dest_dist[i + t] = dist[dest[i]];

		Dijkstra(h);
		temp[3] = dist[g];

		// h -> 목적지까지의 최단경로
		for (int i = 0; i < t; ++i)
			dest_dist[i + t * 2] = dist[dest[i]];

		for (int i = 0; i < t; ++i) {
			answer_g[i] = temp[0] + temp[2] + dest_dist[i + t * 2];		// (s -> g) + (g -> h) + (h -> 목적지)
			answer_h[i] = temp[1] + temp[3] + dest_dist[i + t];		// (s -> h) + (h -> g) + (g -> 목적지)
			answer[i] = MIN(answer_g[i], answer_h[i]);		// 둘 중 더 짧은 경로

			// 둘 중 더 짧은 경로가 최단경로일 경우
			if (answer[i] == dest_dist[i]) cout << dest[i] << ' ';
		}
		cout << '\n';

		for (int i = 1; i <= n; ++i)
			adjacent_v_e[i].clear();
	}
}