#include <iostream>
#include <string>

using namespace std;

string video[64];

void QuadTree(int n, int row_begin, int row_end, int column_begin, int column_end) {
	bool zero = 0, one = 0;

	if (n == 1) {
		if (video[column_begin][row_begin] == '0') cout << "0";
		else cout << "1";
		return;
	}

	for (int i = column_begin; i < column_end; ++i) {
		for (int j = row_begin; j < row_end; ++j) {
			if (video[i][j] == '0') zero = 1;
			else one = 1;

			if (zero == 1 && one == 1) break;
		}
		if (zero == 1 && one == 1) break;
	}

	if (zero == 1 && one == 1) {
		cout << "(";
		QuadTree(n / 2, row_begin, row_begin + n / 2, column_begin, column_begin + n / 2);
		QuadTree(n / 2, row_begin + n / 2, row_end, column_begin, column_begin + n / 2);
		QuadTree(n / 2, row_begin, row_begin + n / 2, column_begin + n / 2, column_end);
		QuadTree(n / 2, row_begin + n / 2, row_end, column_begin + n / 2, column_end);
		cout << ")";
	}
	else if (zero == 1 && one == 0) cout << "0";
	else if (zero == 0 && one == 1) cout << "1";
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> video[i];

	QuadTree(n, 0, n, 0, n);
}