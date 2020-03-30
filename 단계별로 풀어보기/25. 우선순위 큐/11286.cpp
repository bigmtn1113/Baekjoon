#include <iostream>
#include <queue>

#define ABS(X) ((X < 0) ? (X * -1) : (X))

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;		// �ּҰ��� �켱�� ��

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;

		if (input) pq.push({ ABS(input), input });		// push�� ������ ����(ù��° ��)�� ���� ���� ���� �켱�� ��. ������ ������ ���� ��(�ι�° ��)�� ���� �� �켱
		else
			if (pq.empty()) cout << "0\n";
			else { cout << pq.top().second << '\n'; pq.pop(); }		// ���밪�� �ƴ� ���� �� ���.
	}
}