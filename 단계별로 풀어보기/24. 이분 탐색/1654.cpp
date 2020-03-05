include <iostream>

using namespace std;

int k, n;
int lan_cable[10001];

long long ParameticSearch(long long begin, long long end) {
	long long mid, result = 1;
	int cnt;

	while (!(begin > end)) {
		mid = (begin + end) / 2;
		cnt = 0;

		// mid가 0이면 런타임 에러 발생
		if (mid)
			for (int i = 0; i < k; ++i)
				cnt += lan_cable[i] / mid;

		if (cnt >= n) { result = mid; begin = mid + 1; }
		else end = mid - 1;
	}

	return result;

	// ex)	4 11
	//		802 743 457 539일 경우

	// 802가 가장 크므로 begin:0, end: 802, mid: 401로 시작
	// 802 / 401 = 2, 743 / 401 = 1, 457 / 401 = 1, 539 / 401 = 1	=> 2 + 1 + 1 + 1 = 4
	// 4 < 11 => 401이 너무 크므로 랜선의 수가 적게 나옴. 더 작게 잘라야 함.
	// begin: 0, end: 400, mid: 200 ... 과정 반복
	// 반복하다 cnt(랜선의 수) >= 11이면 result에 mid값을 저장한 후 더 큰 값을 찾기 위해 탐색함.
	// 이유는 최대 랜선의 길이를 찾기 위함임.
	// 199로도 11개가 나오고 200으로도 11개가 나온다면 답은 200.
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int max_lan_cable = 0;

	cin >> k >> n;
	for (int i = 0; i < k; ++i) {
		cin >> lan_cable[i];

		if (lan_cable[i] > max_lan_cable)
			max_lan_cable = lan_cable[i];
	}

	cout << ParameticSearch(0, max_lan_cable);
}