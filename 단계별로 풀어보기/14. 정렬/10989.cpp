#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n, input, count = 0;
	int arr[10001] = {};

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &input);
		arr[input - 1]++;
	}

	for (int i = 0; i < 10000; i++)
		for (int j = 0; j < arr[i]; j++) {
			printf("%d\n", i + 1);
			if (++count == n) return 0;
		}
}