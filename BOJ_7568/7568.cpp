#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int t, x, y, cnt;
	int dungchi[51][2];

	scanf("%d", &t);

	for (int i = 0; i < t; i++)
		for (int j = 0; j < 2; j++)
			scanf("%d", &dungchi[i][j]);

	for (int i = 0; i < t; i++) {
		x = dungchi[i][0];
		y = dungchi[i][1];
		cnt = 1;

		for (int j = 0; j < t; j++)
			if (dungchi[j][0] > x && dungchi[j][1] > y)
				cnt++;

		printf("%d ", cnt);
	}
}