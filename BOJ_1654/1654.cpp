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

		// mid�� 0�̸� ��Ÿ�� ���� �߻�
		if (mid)
			for (int i = 0; i < k; ++i)
				cnt += lan_cable[i] / mid;

		if (cnt >= n) { result = mid; begin = mid + 1; }
		else end = mid - 1;
	}

	return result;

	// ex)	4 11
	//		802 743 457 539�� ���

	// 802�� ���� ũ�Ƿ� begin:0, end: 802, mid: 401�� ����
	// 802 / 401 = 2, 743 / 401 = 1, 457 / 401 = 1, 539 / 401 = 1	=> 2 + 1 + 1 + 1 = 4
	// 4 < 11 => 401�� �ʹ� ũ�Ƿ� ������ ���� ���� ����. �� �۰� �߶�� ��.
	// begin: 0, end: 400, mid: 200 ... ���� �ݺ�
	// �ݺ��ϴ� cnt(������ ��) >= 11�̸� result�� mid���� ������ �� �� ū ���� ã�� ���� Ž����.
	// ������ �ִ� ������ ���̸� ã�� ������.
	// 199�ε� 11���� ������ 200���ε� 11���� ���´ٸ� ���� 200.
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