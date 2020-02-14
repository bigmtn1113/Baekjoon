#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int t, n;
	int cnt_index, result;
	string name;

	cin >> t;
	for (int i = 0; i < t; i++) {
		string kind[31];
		int kind_cnt[31] = {};

		cnt_index = 0;
		result = 1;

		cin >> n;
		fill_n(kind_cnt, n, 1);

		for (int j = 0; j < n; j++)
			cin >> name >> kind[j];

		sort(kind, kind + n);

		for (int j = 1; j < n; j++) {
			if (kind[j] == kind[j - 1])
				kind_cnt[cnt_index]++;
			else
				cnt_index++;
		}

		for (int j = 0; j <= cnt_index; j++)
			result *= kind_cnt[j] + 1;

		cout << result - 1 << '\n';
	}
}