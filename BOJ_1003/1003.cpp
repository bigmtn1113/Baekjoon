#include <iostream>
#include <cstdio>

using namespace std;

int cnt[41][41] = { { 1, 0 },{ 0, 1 }, };
int mem[41];

int fibonachi(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	if (mem[n] != 0) return mem[n];
	else {
		mem[n] = fibonachi(n - 1) + fibonachi(n - 2);
		cnt[n][0] = cnt[n - 1][0] + cnt[n - 2][0];
		cnt[n][1] = cnt[n - 1][1] + cnt[n - 2][1];
		return mem[n];
	}
}

int main() {
	int t, n;

	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d", &n);
		fibonachi(n);
		printf("%d %d\n", cnt[n][0], cnt[n][1]);
	}
}