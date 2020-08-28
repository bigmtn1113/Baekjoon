#include <iostream>

#define INF 987654321

using namespace std;

int graph[101][101];
int n;

void FloydWarshall() {
	for (int i = 1; i <= n; ++i) {				// �����ϴ� ��
		for (int j = 1; j <= n; ++j) {			// �����ϴ� ��
			for (int k = 1; k <= n; ++k) {		// �����ϴ� ��
				if (graph[j][k] > graph[j][i] + graph[i][k])	// ���� -> ���� vs ���� -> ���� -> ���� ��
					graph[j][k] = graph[j][i] + graph[i][k];
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int m, a, b, c;

	cin >> n >> m;

	for (int i = 1; i <= n; ++i)
		for (int j = 1; j <= n; ++j) {
			if (i == j) graph[i][j] = 0;
			else graph[i][j] = INF;
		}

	while (m--) {
		cin >> a >> b >> c;

		if (graph[a][b] > c)
			graph[a][b] = c;
	}

	FloydWarshall();

	for (int i = 1; i <= n; ++i) {
		for (int j = 1; j <= n; ++j)
			graph[i][j] == INF ? cout << "0 " : cout << graph[i][j] << ' ';
		cout << '\n';
	}
}