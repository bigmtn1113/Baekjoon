#include <iostream>
#include <cstdio>
#include <cstdlib>

using namespace std;

int arr[9][9];

bool check(int row, int col) {
	for (int k = 0; k < 9; k++)
		if (k != col && arr[row][col] == arr[row][k]) return false;
	for (int k = 0; k < 9; k++)
		if (k != row && arr[row][col] == arr[k][col]) return false;
	for (int k = row / 3 * 3; k < row / 3 * 3 + 3; k++)
		for (int l = col / 3 * 3; l < col / 3 * 3 + 3; l++)
			if ((k != row || l != col) && arr[row][col] == arr[k][l]) return false;

	return true;
}

void sudoku(int index) {
	int row = index / 9;
	int col = index % 9;

	if (index == 81) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				printf("%d ", arr[i][j]);
			printf("\n");
		}
		exit(0);
	}
	if (arr[row][col] == 0) {
		for (int num = 1; num <= 9; num++) {
			arr[row][col] = num;
			if (check(row, col))
				sudoku(index + 1);
		}
		arr[row][col] = 0;
		return;
	}
	else sudoku(++index);
}

int main() {
	for (int i = 0; i < 9; i++)
		for (int j = 0; j < 9; j++)
			scanf("%d", &arr[i][j]);

	sudoku(0);
}