#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n;
	int mem[1000001];

	scanf("%d", &n);
	fill_n(mem, n, 0);
	mem[1] = 1;
	mem[2] = 2;

	for (int i = 3; i <= n; i++)
		mem[i] = (mem[i - 1] + mem[i - 2]) % 15746;

	printf("%d", mem[n]);
}