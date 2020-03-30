#include <iostream>
#include <queue>

#define ABS(X) ((X < 0) ? (X * -1) : (X))

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input;
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;		// 최소값이 우선인 힙

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;

		if (input) pq.push({ ABS(input), input });		// push할 때마다 절댓값(첫번째 값)이 가장 작은 것이 우선이 됨. 절댓값이 같으면 원래 값(두번째 값)이 작은 게 우선
		else
			if (pq.empty()) cout << "0\n";
			else { cout << pq.top().second << '\n'; pq.pop(); }		// 절대값이 아닌 원래 값 출력.
	}
}