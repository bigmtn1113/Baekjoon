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

	// �� ��ǥ�� num�̻��� ���� ������ ù �ε��� ã��
	// ex) 1 2 3 3 4 5���� num�� 3�̸� -> return 2
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

	// �� ù ���� �����⸦ ��ġ�ϰ� ����
	// i(���� �����⸦ ��ġ�� �� ��ǥ)�� distance(�Ÿ�)�� ������ �� �� �� �̻��� ���� ������ �� ��ǥ�� LowerBound �Լ��� ���� ã��
}

int BinarySearch(int begin, int end) {
	int mid, result;

	while (begin <= end) {
		mid = (begin + end) / 2;
		if (!FindDistance(mid)) end = mid - 1;
		else { result = mid; begin = mid + 1; }
	}

	return result;

	// mid(�Ÿ�)�� �������� �� ������ ��ġ�� ������ �� FindDistance �Լ��� ���� Ȯ��
	// - ��ġ ���� -> �� �ָ� ��ġ������ �� Ž��
	// - ��ġ �Ұ��� -> �� ���� ��ġ�ϵ��� ����
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

// ex)	�� ���� = 5, ������ ���� = 3
//		�� ��ǥ = 1, 2, 4, 8, 9
// begin: 0, end: 9, mid: 4	-> 1, 8 -> ��ġ �Ұ�. �Ÿ��� �� �۰� ����
// begin: 0, end: 3, mid: 1 -> 1, 2, 4 -> ��ġ ����. �Ÿ��� �� ũ�� ����
// begin: 2, end: 3, mid: 2 -> 1, 4, 8 -> ��ġ ����. �Ÿ��� �� ũ�� ����
// begin: 3, end: 3, mid: 3 -> 1, 4, 8 -> ��ġ ����.
// ��: 3