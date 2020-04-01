#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;
	int a[1000001], index[1000001] = { 0 }, cnt = 0;
	vector<int> lis, result;

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];

	lis.push_back(a[0]);
	index[0] = 0;

	// ex)
	// a:		10 20 10 30 20 50
	// lis:		10 -> 10, 20 -> 10, 20 -> 10, 20, 30 -> 10, 20, 30 -> 10, 20, 30, 50
	// index:	0  1  0  2  1  3
	for (int i = 1; i < n; ++i) {
		// lis �� ���� �ִ� ���Һ��� a[i]�� ũ�� lis�� �߰�
		if (lis[cnt] < a[i]) {
			lis.push_back(a[i]);
			index[i] = ++cnt;
		}
		// lis �� ���� �ִ� ���Һ��� a[i]�� �۰ų� ������ a[i]�� �� �� ã�Ƽ� ����
		// pos: a[i]�� �� ��
		else {
			int pos = lower_bound(lis.begin(), lis.end(), a[i]) - lis.begin();
			lis[pos] = a[i];
			index[i] = pos;
		}
	}

	cout << cnt + 1 << '\n';

	// a:		10 20 10 30 20 50
	// index:	0  1  0  2  1  3
	// cnt:		3 -> 2 -> 1 -> 0
	// result:	50 -> 50, 30 -> 50, 30, 20 -> 50, 30, 20, 10
	for (int i = n - 1; i >= 0 && cnt >= 0; --i) {
		if (index[i] == cnt) {
			result.push_back(a[i]);
			cnt--;
		}
	}

	// 50 -> 30 -> 20 -> 10�� �Ųٷ� ���
	// 10 -> 20 -> 30 -> 50
	for (int i = result.size() - 1; i >= 0; --i)
		cout << result[i] << ' ';
}