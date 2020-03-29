#include <iostream>

#define INF 987654321

using namespace std;

int graph[401][401];

void FloydWarshall(int v) {
	for (int i = 1; i <= v; ++i) {
		for (int j = 1; j <= v; ++j) {
			for (int k = 1; k <= v; ++k) {
				if (graph[j][k] > graph[j][i] + graph[i][k])
					graph[j][k] = graph[j][i] + graph[i][k];
			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int v, e;
	int min = INF;

	cin >> v >> e;
	while (e--) {
		int a, b, c;

		cin >> a >> b >> c;
		graph[a][b] = c;
	}

	for (int i = 1; i <= v; ++i)
		for (int j = 1; j <= v; ++j)
			if (!graph[i][j]) graph[i][j] = INF;

	FloydWarshall(v);

	// a와 b가 사이클?
	// (a -> b) + (b -> a) = (a -> a)
	for (int i = 1; i <= v; ++i)
		for (int j = 1; j <= v; ++j)
			if (i != j && min > graph[i][j] + graph[j][i])
				min = graph[i][j] + graph[j][i];

	/*
	// 다른 방법
	// graph[a][a]에 값이 INF가 아니다?
	// a에서 시작해서 다른 곳을 거쳐 다시 a로 왔을 때 값이 변했다. 즉, 사이클이 존재한다.
	for (int i = 1; i <= v; ++i)
		if (min > graph[i][i]) min = graph[i][i];
	*/

	(min != INF) ? cout << min : cout << -1;
}