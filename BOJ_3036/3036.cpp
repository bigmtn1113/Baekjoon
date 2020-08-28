#include <iostream>

using namespace std;

int GCD(int a, int b) {
	return a % b == 0 ? b : GCD(b, a % b);
}

int main() {
	int n;
	int radius[101];

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &radius[i]);

	for (int i = 1; i < n; i++)
		printf("%d/%d\n", radius[0] / GCD(radius[0], radius[i]), radius[i] / GCD(radius[0], radius[i]));
}