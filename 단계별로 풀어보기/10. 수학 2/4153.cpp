#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int a, b, c;

	while (true) {
		scanf("%d %d %d", &a, &b, &c);
		if (a == 0 && b == 0 && c == 0) return 0;

		if (a > b && a > c) {
			if (a * a == b * b + c * c) printf("right\n");
			else printf("wrong\n");
		}
		if (b > c && b > a) {
			if (b * b == a * a + c * c) printf("right\n");
			else printf("wrong\n");
		}
		if (c > b && c > a) {
			if (c * c == b * b + a * a) printf("right\n");
			else printf("wrong\n");
		}
	}
}