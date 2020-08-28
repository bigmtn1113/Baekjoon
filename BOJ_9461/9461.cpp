#include <iostream>
#include <cstdio>

using namespace std;

long long int mem[101] = { 0, 1, 1, 1, 2, 2, };

long long int padovan(int n) {
	if (mem[n] != 0) return mem[n];
	return mem[n] = padovan(n - 5) + padovan(n - 1);
}

int main() {
	int t, n;

	scanf("%d", &t);
	for (int i = 0; i < t; i++) {
		scanf("%d", &n);
		printf("%lld\n", padovan(n));
	}
}