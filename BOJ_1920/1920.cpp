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

	// �ݾ� �ɰ��� ã��
	// ex) 2�� ã�ƺ���
	// 1 2 3 4 5 -> �߾Ӱ� 3�� �� -> ������ 1 2��, ũ�� 4 5�� �̵�
	// 2�� 3���� ������ 1 2�� �̵�
	// �߾Ӱ� 1�� �� -> 2�� 1���� ũ�� 2�� �̵�
	// 2 == 2 �̹Ƿ� return true
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