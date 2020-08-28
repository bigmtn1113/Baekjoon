#include <iostream>
#include <vector>
#include <algorithm>

#define INF 0x7fffffff

using namespace std;

vector<pair<int, int>> adjacent_v_e[501];
int dist[501];
int n;

bool BellmanFord(int src) {
	dist[src] = 0;

	int next, next_weight;
	bool is_minus_cycle = false;

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j) {
			for (int k = 0; k < adjacent_v_e[j].size(); ++k) {
				next = adjacent_v_e[j][k].first;
				next_weight = adjacent_v_e[j][k].second;

				if (dist[j] != INF && dist[next] > dist[j] + next_weight) {
					dist[next] = dist[j] + next_weight;

					// 1 ~ (n - 1) 까지 계산하면 이미 최단거리 계산이 끝남.
					// 여기서 한번 더 계산을 해보는데 이때 dist값이 바뀌면 음수 싸이클이 존재한다는 뜻.
					if (i == n) is_minus_cycle = true;
				}
			}
		}
	}

	return is_minus_cycle;

	// 벨만 포드
	// 다익스트라와 달리 가중치가 음수여도 사용가능. 그리고 음수 싸이클이 존재하는지 확인 가능.
	// 단, 다익스트라보다 느림.
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int m, a, b, c;

	cin >> n >> m;
	while (m--) {
		cin >> a >> b >> c;
		adjacent_v_e[a].push_back({ b, c });
	}

	fill_n(dist, n + 1, INF);

	// 음수 싸이클이 존재할 경우 -1 출력
	if (BellmanFord(1))
		cout << -1;
	else
		for (int i = 2; i <= n; ++i)
			dist[i] == INF ? cout << "-1\n" : cout << dist[i] << '\n';
}