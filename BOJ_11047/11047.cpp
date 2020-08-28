#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n, k, cnt = 0;
	int money[11];

	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++)
		scanf("%d", &money[i]);

	for (int i = n - 1; i >= 0; i--) {
		if (k >= money[i]) {
			cnt += k / money[i];
			k -= k / money[i] * money[i];
		}
	}
	printf("%d", cnt);
}