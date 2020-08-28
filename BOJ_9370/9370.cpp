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
		
		// ������ �ĺ� �������� ���� ����� ���� ����
		sort(dest, dest + t);

		// ��Ŀ�� ������ �� ���� ���������� �ִܰŸ��� �̵��� ���̰�, g�� h ������ ���̿� �ִ� ���θ� ��������?
		// -> g�� h ������ ���̿� �ִ� ���θ� ������ ���� �ִܰ�ΰڱ�.

		// �׷� g�� ���� �����°� �ִܰ���ϱ�? h�� ���� �����°� �ִܰ���ϱ�?
		// -> �� �� �� ª�� ���� ���̰ڳ�.

		// s -> g -> h -> ������: g ���
		// s -> h -> g -> ������: h ���

		Dijkstra(s);
		temp[0] = dist[g];		// g ���
		temp[1] = dist[h];		// h ���

		// s -> ������������ �ִܰ��
		// g ��ζ� h ��� �� ������� �ִܰ������ ���ϱ� ����
		for (int i = 0; i < t; ++i)
			dest_dist[i] = dist[dest[i]];

		Dijkstra(g);
		temp[2] = dist[h];

		// g -> ������������ �ִܰ��
		for (int i = 0; i < t; ++i)
			dest_dist[i + t] = dist[dest[i]];

		Dijkstra(h);
		temp[3] = dist[g];

		// h -> ������������ �ִܰ��
		for (int i = 0; i < t; ++i)
			dest_dist[i + t * 2] = dist[dest[i]];

		for (int i = 0; i < t; ++i) {
			answer_g[i] = temp[0] + temp[2] + dest_dist[i + t * 2];		// (s -> g) + (g -> h) + (h -> ������)
			answer_h[i] = temp[1] + temp[3] + dest_dist[i + t];		// (s -> h) + (h -> g) + (g -> ������)
			answer[i] = MIN(answer_g[i], answer_h[i]);		// �� �� �� ª�� ���

			// �� �� �� ª�� ��ΰ� �ִܰ���� ���
			if (answer[i] == dest_dist[i]) cout << dest[i] << ' ';
		}
		cout << '\n';

		for (int i = 1; i <= n; ++i)
			adjacent_v_e[i].clear();
	}
}