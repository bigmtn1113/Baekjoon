#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, X, A;

	cin >> N >> X;
	for (int i = 0; i < N; i++) {
		cin >> A;
		if (A < X)
			cout << A << " ";
	}
}