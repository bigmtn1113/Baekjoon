#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, m, k, t = 0, result;
	int n_m[100][100] = {}, m_k[100][100] = {};

	cin >> n >> m;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < m; ++j)
			cin >> n_m[i][j];

	cin >> m >> k;
	for (int i = 0; i < m; ++i)
		for (int j = 0; j < k; ++j)
			cin >> m_k[i][j];

	for (int i = 0; i < n; ++i) {
		result = 0;
		for (int j = 0; j < m; ++j)
			result += n_m[i][j] * m_k[j][t];

		cout << result << " ";

		++t;
		if (t < k) --i;
		else { t = 0; cout << '\n'; }
	}
}