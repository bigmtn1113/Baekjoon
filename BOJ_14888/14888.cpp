#include <iostream>
#include <cstdio>
#include <cstdlib>

using namespace std;

int n;
int num[12];
int op[4];

void InsertOperator(int cnt, int result, int &max, int &min) {
	if (cnt == n - 1) {
		if (min > result) min = result;
		if (max < result) max = result;
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (op[i] != 0) {
			op[i]--;
			if (i == 0) InsertOperator(cnt + 1, result + num[cnt + 1], max, min);
			else if (i == 1) InsertOperator(cnt + 1, result - num[cnt + 1], max, min);
			else if (i == 2) InsertOperator(cnt + 1, result * num[cnt + 1], max, min);
			else InsertOperator(cnt + 1, result / num[cnt + 1], max, min);
			op[i]++;
		}
	}
}

int main() {
	int min = 1000000001, max = -min;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &num[i]);

	for (int i = 0; i < 4; i++)
		scanf("%d", &op[i]);

	InsertOperator(0, num[0], max, min);
	printf("%d\n%d", max, min);
}