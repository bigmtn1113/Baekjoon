#include <iostream>
#include <queue>
#include <vector>

using namespace std;

vector<pair<int, int>> adj[1001];
int dist[1001];
int pre_city[1001];	// 이전 도시

void Dijkstra(int begin) {
	priority_queue<pair<int, int>> pq;	// 우선순위 큐. 기본적으론 제일 큰 값이 top이기 때문에 최솟값이 top이려면 -를 붙이고 넣고 빼야함
	pq.push({ 0, begin });		// 시작 지점 큐에 넣기
	dist[begin] = 0;		// 시작 지점은 비용이 0

	while (!pq.empty()) {
		int cost = -pq.top().first;	// 현재 있는 도시까지 오는데 드는 비용
		int city = pq.top().second;	// 현재 있는 도시
		pq.pop();

		if (dist[city] < cost)		// 현재 있는 도시까지 오는데 드는 최소 비용보다 cost가 크면 패스~
			continue;

		for (int i = 0; i < adj[city].size(); ++i) {
			int next_city = adj[city][i].first;		// 다음 도시
			int next_cost = adj[city][i].second;		// 다음 도시가는데 드는 비용

			if (dist[next_city] > dist[city] + next_cost) {		// 다음 도시가는데 드는 최소 비용보다 현재 있는 도시를 거쳐가는 비용이 더 적을경우
				dist[next_city] = cost + next_cost;
				pq.push({ -dist[next_city], next_city });
				pre_city[next_city] = city;			// 다음 도시로 가기 전에 현재 있는 도시 저장
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
	for (int i = result.size() - 1; i >= 0; --i)	// 거꾸로 출력
		cout << result[i] << ' ';
}
