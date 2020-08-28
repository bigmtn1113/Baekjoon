#include <iostream>

using namespace std;

int n;
int matrix[5][5], temp_matrix[5][5], result_matrix[5][5];

void MultiplyMatrix(int m1[][5], int m2[][5]) {
	int result, t = 0;

	for (int i = 0; i < n; ++i) {
		result = 0;
		for (int j = 0; j < n; ++j)
			result += (m1[i][j] * m2[j][t]) % 1000;

		result_matrix[i][t] = result % 1000;

		++t;
		if (t < n) --i;
		else t = 0;
	}

	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j)
			matrix[i][j] = result_matrix[i][j];
}

void Mod(unsigned long long num) {
	if (num == 1) return;

	Mod(num / 2);
	if (num % 2 > 0) { MultiplyMatrix(matrix, matrix); return MultiplyMatrix(matrix, temp_matrix); }
	else return MultiplyMatrix(matrix, matrix);
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	unsigned long long b;

	cin >> n >> b;
	for (int i = 0; i < n; ++i)
		for (int j = 0; j < n; ++j) {
			cin >> matrix[i][j];
			matrix[i][j] %= 1000;
			temp_matrix[i][j] = matrix[i][j];
		}

	Mod(b);

	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j)
			cout << matrix[i][j] << " ";
		cout << '\n';
	}
}