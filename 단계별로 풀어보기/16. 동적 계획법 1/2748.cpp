#include <iostream>
#include <cstdio>

using namespace std;

int n;
long long int mem[91];

long long int fibonachi(int n) {
	if (n == 0) return 0;
	if (n == 1) return 1;
	if (mem[n] != 0) return mem[n];
	return mem[n] = fibonachi(n - 1) + fibonachi(n - 2);
}

int main() {
	scanf("%d", &n);
	printf("%lld", fibonachi(n));
}