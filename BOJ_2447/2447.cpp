#include <iostream>
#include <cstdio>

using namespace std;

char **arr;

void star(int n, int x, int y) {
	if (n == 1) {
		arr[x][y] = '*';
		return;
	}
	int div = n / 3;
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			if (i != 1 || j != 1) star(div, x + (div * i), y + (div * j));
	return;
}

int main() {
	int n;

	scanf("%d", &n);
	arr = new char*[n];
	for (int i = 0; i < n; i++) {
		arr[i] = new char[n];
		fill_n(arr[i], n, ' ');
	}

	star(n, 0, 0);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			printf("%c", arr[i][j]);
		printf("\n");
	}

	for (int i = 0; i < n; i++)
		delete arr[i];
	delete arr;
}