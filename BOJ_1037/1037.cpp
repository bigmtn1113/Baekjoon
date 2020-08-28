#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

int main() {
	int n;
	int factor[51];

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &factor[i]);

	sort(factor, factor + n);

	printf("%d", factor[0] * factor[n - 1]);
}