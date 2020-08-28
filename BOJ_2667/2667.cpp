#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <string>

using namespace std;

vector<int> adjacent_vertex[26 * 26];
queue<int> q;
bool is_visit[26 * 26];
bool map[26][26];
int cnt;

void Dfs(int vertex) {
	is_visit[vertex] = true;
	++cnt;

	for (int i = 0; i < adjacent_vertex[vertex].size(); ++i)
		if (!is_visit[adjacent_vertex[vertex][i]])
			Dfs(adjacent_vertex[vertex][i]);
}

void Bfs(int vertex) {
	int current;

	q.push(vertex);
	is_visit[vertex] = true;

	while (!q.empty()) {
		current = q.front();
		q.pop();

		++cnt;

		for (int i = 0; i < adjacent_vertex[current].size(); ++i)
			if (!is_visit[adjacent_vertex[current][i]]) {
				q.push(adjacent_vertex[current][i]);
				is_visit[adjacent_vertex[current][i]] = true;
			}
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, housing_complex_cnt = 0;
	int house_cnt[26 * 26] = {};
	string input;

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		for (int j = 0; j < input.length(); ++j)
			map[i][j] = input[j] - '0';
	}

	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j) {
			if (!map[i][j]) continue;

			if (i && map[i - 1][j]) adjacent_vertex[n * i + j].push_back(n * (i - 1) + j);
			if (j && map[i][j - 1]) adjacent_vertex[n * i + j].push_back(n * i + j - 1);
			if (j != n - 1 && map[i][j + 1]) adjacent_vertex[n * i + j].push_back(n * i + j + 1);
			if (i != n - 1 && map[i + 1][j]) adjacent_vertex[n * i + j].push_back(n * (i + 1) + j);
		}

	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			if (map[i][j] && !is_visit[i * n + j]) {
				Dfs(i * n + j);
				// Bfs(i * n + j);
				house_cnt[housing_complex_cnt++] = cnt;
				cnt = 0;
			}

	sort(house_cnt, house_cnt + housing_complex_cnt);

	cout << housing_complex_cnt << '\n';
	for (int i = 0; i < housing_complex_cnt; ++i)
		cout << house_cnt[i] << '\n';
}