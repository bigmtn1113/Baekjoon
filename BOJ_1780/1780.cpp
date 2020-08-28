#include <iostream>

using namespace std;

int paper[2187][2187];
int minus_cnt, zero_cnt, one_cnt;

void NonaTree(int n, int row_begin, int column_begin) {
	bool check = 0;

	if (n == 1) {
		if (paper[column_begin][row_begin] == -1) ++minus_cnt;
		else if (paper[column_begin][row_begin] == 0) ++zero_cnt;
		else ++one_cnt;
		return;
	}

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j)
			if (paper[column_begin][row_begin] != paper[column_begin + i][row_begin + j]) { check = 1; break; }
		if (check) break;
	}

	if (check)
		for (int i = 0; i < 3; ++i)
			for (int j = 0; j < 3; ++j)
				NonaTree(n / 3, row_begin + n / 3 * j, column_begin + n / 3 * i);
	else {
		if (paper[column_begin][row_begin] == -1) ++minus_cnt;
		else if (paper[column_begin][row_begin] == 0) ++zero_cnt;
		else ++one_cnt;
	}
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			cin >> paper[i][j];

	NonaTree(n, 0, 0);
	cout << minus_cnt << '\n' << zero_cnt << '\n' << one_cnt;
}