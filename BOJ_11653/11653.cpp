#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n, prime_factor = 2;

	scanf("%d", &n);
	while (true) {
		if (n == 1) break;

		if (n % prime_factor == 0) {
			n /= prime_factor;
			printf("%d\n", prime_factor);
		}
		else
			prime_factor++;
	}
}