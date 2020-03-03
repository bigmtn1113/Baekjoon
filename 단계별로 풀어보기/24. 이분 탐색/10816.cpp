#include <iostream>
#include <algorithm>

using namespace std;

int num;
int card[500001];

int LowerBound(int begin, int end) {
	int mid;

	while (begin != end) {
		mid = (begin + end) / 2;
		if (num > card[mid]) begin = mid + 1;
		else end = mid;
	}
	return end;

	// num이상의 수가 처음 나오는 위치 찾기
	// ex) 1 2 3 3 3 4 5 6에서 3이 처음 나오는 위치 찾기
	// begin: 0, end: 8, mid: 4 -> 3 == 3
	// begin: 0, end: 4, mid: 2 -> 3 == 3
	// begin: 0, end: 2, mid: 1 -> 3 > 2
	// begin: 2, end: 2 -> return 2
	// 단순 이분 탐색과 다르게 end 범위가 1 더 크다.
	// 값이 아니라 값의 최소 인덱스를 찾기 때문에 값을 찾아도 진행한다.
}

int UpperBound(int begin, int end) {
	int mid;

	while (begin != end) {
		mid = (begin + end) / 2;
		if (num >= card[mid]) begin = mid + 1;
		else end = mid;
	}
	return end;

	// num보다 큰 수가 처음 나오는 위치 찾기
	// ex) 1 2 3 3 3 4 5 6에서 3보다 큰 수가 처음 나오는 위치 찾기
	// begin: 0, end: 8, mid: 4 -> 3 == 3
	// begin: 5, end: 8, mid: 6 -> 3 < 5
	// begin: 5, end: 6, mid: 5 -> 3 < 4
	// begin: 5, end: 5 -> return 5
	// 단순 이분 탐색과 다르게 end 범위가 1 더 크다.
	// 값이 아니라 값보다 큰 수의 첫 인덱스를 찾기 때문에 값을 찾아도 진행한다.
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, m, cnt;

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> card[i];

	sort(card, card + n);

	cin >> m;
	for (int i = 0; i < m; ++i) {
		cin >> num;
		cnt = 0;

		if (!(num < card[0] || num > card[n - 1]))
			cnt = UpperBound(0, n) - LowerBound(0, n);

		cout << cnt << " ";
	}
}

// 함수 사용
/*
#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, m, num, cnt;
    int card[500001];

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> card[i];

	sort(card, card + n);

	cin >> m;
	for (int i = 0; i < m; ++i) {
		cin >> num;
		cnt = 0;

		if (!(num < card[0] || num > card[n - 1])) {
			cnt = upper_bound(card, card + n, num) - card + 1;
			cnt -= lower_bound(card, card + n, num) - card + 1;
		}
			
		cout << cnt << " ";
	}
}
*/