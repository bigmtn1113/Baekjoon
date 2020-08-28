#include <iostream>
#include <cstdio>
#include <cstdlib>

using namespace std;

int n, cnt = 0;
int arr[16];

bool check(int row, int col) {
	for (int i = 0; i < row; i++)
		if (arr[i] == col || abs(arr[i] - col) == abs(row - i))
			return false;
	return true;
}

void n_queen(int row) {
	if (row == n) {
		cnt++;
		return;
	}

	for (int col = 0; col < n; col++) {
		if (row == 0 || check(row, col)) {
			arr[row] = col;
			n_queen(row + 1);
			arr[row] = 0;
		}
	}
}

int main() {
	scanf("%d", &n);

	n_queen(0);
	printf("%d", cnt);
}