#include <iostream>
#include <queue>
#include <string>
#include <cstring>

using namespace std;

bool visit[10001];

string Bfs(int from, int to) {
	queue<pair<int, string>> q;
	q.push({ from, "" });
	visit[from] = true;

	int current, next[4];
	string command, next_command[4] = { "D", "S", "L", "R" };		// string 및 배열을 반복문 돌때마다 생성하지 않기 위해 while문 밖에 선언

	while (!q.empty()) {
		current = q.front().first;
		command = q.front().second;
		q.pop();

		if (current == to) return command;

		next[0] = 2 * current % 10000;
		next[1] = (current - 1 < 0) ? 9999 : current - 1;
		next[2] = current % 1000 * 10 + current / 1000;
		next[3] = current % 10 * 1000 + current / 10;

		for (int i = 0; i < 4; ++i) {
			if (!visit[next[i]]) {
				q.push({ next[i], command + next_command[i] });		// 다음으로 넘어갈 때 어떤 명령으로 인해 넘어간 건지 저장
				visit[next[i]] = true;
			}
		}
	}
	return "";
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t;

	cin >> t;
	while (t--) {
		int from, to;

		cin >> from >> to;
		cout << Bfs(from, to) << '\n';

		memset(visit, false, sizeof(visit));
	}
}