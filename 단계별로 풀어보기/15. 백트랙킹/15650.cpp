#include <iostream>
#include <cstdio>

using namespace std;

int n, m;
int arr[9];
bool visited[9];

void dfs(int cnt) {
	if (cnt == m) {
		for (int i = 0; i < m; i++)
			printf("%d ", arr[i]);
		printf("\n");
		return;
	}

	for (int i = 0; i < n; i++) {
		if (!visited[i]) {
			visited[i] = true;
			arr[cnt] = i + 1;
			if (cnt == 0 || arr[cnt] > arr[cnt - 1])
				dfs(cnt + 1);
			visited[i] = false;
		}
	}
}

int main() {
	scanf("%d %d", &n, &m);
	dfs(0);
}