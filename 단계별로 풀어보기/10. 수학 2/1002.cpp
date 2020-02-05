#include <iostream>
#include <cstdio>
#include <cmath>
#include <cstdlib>

using namespace std;

int main() {
	int t, x1, y1, x2, y2, r1, r2, r2_r1;
	double d;

	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);
		d = sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		r2_r1 = abs(r2 - r1);

		if (d == 0 && r2_r1 == 0) { printf("-1\n"); continue; }
		if (r2_r1 < d && d < r1 + r2) { printf("2\n"); continue; }
		if (d == r1 + r2) { printf("1\n"); continue; }
		if (d == r2_r1) { printf("1\n"); continue; }
		if (d > r1 + r2) { printf("0\n"); continue; }
		if (d <= r2_r1) { printf("0\n"); continue; }
	}
}