#include <iostream>
#include <algorithm>

using namespace std;

int n, c;
int home[200001];

int LowerBound(int begin, int end, int num) {
	int mid;

	while (begin != end) {
		mid = (begin + end) / 2;
		if (num > home[mid]) begin = mid + 1;
		else end = mid;
	}

	return end;

	// 집 좌표중 num이상의 값이 나오는 첫 인덱스 찾기
	// ex) 1 2 3 3 4 5에서 num이 3이면 -> return 2
}

bool FindDistance(int distance) {
	int router_cnt = c - 1;

	for (int i = home[0]; i <= home[n - 1];) {
		if (!router_cnt) break;
		if (i + distance > home[n - 1]) return false;

		i = home[LowerBound(0, n, i + distance)];

		--router_cnt;
	}

	return true;

	// 맨 첫 집에 공유기를 설치하고 시작
	// i(전에 공유기를 설치한 집 자표)에 distance(거리)를 더했을 때 그 값 이상의 값이 나오는 집 좌표를 LowerBound 함수를 통해 찾기
}

int BinarySearch(int begin, int end) {
	int mid, result;

	while (begin <= end) {
		mid = (begin + end) / 2;
		if (!FindDistance(mid)) end = mid - 1;
		else { result = mid; begin = mid + 1; }
	}

	return result;

	// mid(거리)를 설정했을 때 공유기 설치가 가능한 지 FindDistance 함수를 통해 확인
	// - 설치 가능 -> 더 멀리 설치가능한 지 탐색
	// - 설치 불가능 -> 더 좁게 설치하도록 설정
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> n >> c;

	for (int i = 0; i < n; ++i)
		cin >> home[i];

	sort(home, home + n);

	cout << BinarySearch(0, home[n - 1]);
}

// ex)	집 개수 = 5, 공유기 개수 = 3
//		집 좌표 = 1, 2, 4, 8, 9
// begin: 0, end: 9, mid: 4	-> 1, 8 -> 설치 불가. 거리를 더 작게 설정
// begin: 0, end: 3, mid: 1 -> 1, 2, 4 -> 설치 가능. 거리를 더 크게 설정
// begin: 2, end: 3, mid: 2 -> 1, 4, 8 -> 설치 가능. 거리를 더 크게 설정
// begin: 3, end: 3, mid: 3 -> 1, 4, 8 -> 설치 가능.
// 답: 3