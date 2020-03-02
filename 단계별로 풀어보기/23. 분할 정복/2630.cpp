#include <iostream>

using namespace std;

bool paper[128][128];
int white_cnt, blue_cnt;

void QuadTree(int n, int row_begin, int row_end, int column_begin, int column_end) {
	bool white = 0, blue = 0;

	if (n == 1) {
		if (paper[column_begin][row_begin] == 0) ++white_cnt;
		else ++blue_cnt;
		return;
	}

	for (int i = column_begin; i < column_end; ++i) {
		for (int j = row_begin; j < row_end; ++j) {
			if (paper[i][j] == 0) white = 1;
			else blue = 1;

			if (white == 1 && blue == 1) break;
		}
		if (white == 1 && blue == 1) break;
	}

	if (white == 1 && blue == 1) {
		QuadTree(n / 2, row_begin, row_begin + n / 2, column_begin, column_begin + n / 2);
		QuadTree(n / 2, row_begin + n / 2, row_end, column_begin, column_begin + n / 2);
		QuadTree(n / 2, row_begin, row_begin + n / 2, column_begin + n / 2, column_end);
		QuadTree(n / 2, row_begin + n / 2, row_end, column_begin + n / 2, column_end);
	}
	else if (white == 1 && blue == 0) ++white_cnt;
	else if (white == 0 && blue == 1) ++blue_cnt;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; j++)
			cin >> paper[i][j];

	QuadTree(n, 0, n, 0, n);
	cout << white_cnt << '\n' << blue_cnt;
}