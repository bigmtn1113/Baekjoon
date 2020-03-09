#include <iostream>
#define MIN(X, Y) X > Y ? Y : X

using namespace std;

int n, k;

int ParametricSearch(int begin, int end) {
	int mid, cnt, result;

	while (begin <= end) {
		cnt = 0;
		mid = (begin + end) / 2;

		for (int i = 1; i <= n; ++i)
			cnt += MIN(mid / i, n);

		if (cnt < k) begin = mid + 1;
		else { result = mid; end = mid - 1; }
	}

	return result;

	// ex) 3x3 배열, 7번째 원소 찾기
	// 1 2 3
	// 2 4 6
	// 3 6 9
	// 오름차순 정렬하면 1 2 2 3 3 4 6 6 9

	// 7번째 숫자는 7보다 작거나 같으므로 7보다 작거나 같은 숫자 개수를 새면 정렬하지 않고서도 해결 가능
	// begin: 1, end: 7, mid: 4		-> cnt(4보다 작거나 같은 숫자 개수) = 3 + 4/2 + 4/3 = 6		-> 6 < 7
	// begin: 5, end: 7, mid: 6		-> cnt(6보다 작거나 같은 숫자 개수) = 3 + 6/2 + 6/3 = 8		-> 8 > 7
	// begin: 5, end: 5, mid: 5		-> cnt(5보다 작거나 같은 숫자 개수) = 3 + 5/2 + 5/3 = 6		-> 6 < 7
	// return 6
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> k;

	cout << ParametricSearch(1, k);
}