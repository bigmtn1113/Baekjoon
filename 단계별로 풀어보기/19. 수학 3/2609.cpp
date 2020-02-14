#include <iostream>
#include <cstdio>

using namespace std;

int gcd(int a, int b) {
	int temp;

	while (true) {
		if (b == 0) return a;

		temp = a;
		a = b;
		b = temp % b;
	}
}

int lcm(int a, int b) {
	return a * b / gcd(a, b);
}

int main() {
	int a, b;

	scanf("%d %d", &a, &b);
	printf("%d\n%d", gcd(a, b), lcm(a, b));
}