#include <iostream>

using namespace std;

int n, m;
int tree[1000001];

int ParameticSearch(int begin, int end) {
	int mid, result = 1;
	long long cnt;

	while (end >= begin) {
		mid = (begin + end) / 2;
		cnt = 0;

		for (int i = 0; i < n; ++i)
			if (tree[i] > mid)
				cnt += tree[i] - mid;

		if (cnt >= m) { result = mid; begin = mid + 1; }
		else end = mid - 1;
	}

	return result;

	// 백준 1654번 랜선 자르기와 비슷한 문제
	// 풀이도 비슷
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int max_tree = 0;

	cin >> n >> m;
	for (int i = 0; i < n; ++i) {
		cin >> tree[i];

		if (tree[i] > max_tree)
			max_tree = tree[i];
	}

	cout << ParameticSearch(0, max_tree);
}