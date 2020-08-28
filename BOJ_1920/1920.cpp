#include <iostream>
#include <algorithm>

using namespace std;

int a[100001];
int n, m, num;

bool BinarySearch(int begin, int end) {
	if (begin > end) return false;

	int mid = (begin + end) / 2;

	if (num == a[mid]) return true;
	else if (num < a[mid]) return BinarySearch(begin, mid - 1);
	else return BinarySearch(mid + 1, end);

	// 반씩 쪼개서 찾기
	// ex) 2를 찾아보자
	// 1 2 3 4 5 -> 중앙값 3과 비교 -> 작으면 1 2로, 크면 4 5로 이동
	// 2가 3보다 작으니 1 2로 이동
	// 중앙값 1과 비교 -> 2가 1보다 크니 2로 이동
	// 2 == 2 이므로 return true
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];

	sort(a, a + n);

	cin >> m;
	for (int i = 0; i < m; ++i) {
		cin >> num;

		if (num < a[0] || num > a[n - 1])
			cout << "0\n";
		else
			BinarySearch(0, n - 1) ? cout << "1\n" : cout << "0\n";
	}
}