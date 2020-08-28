#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n;
	int five_cnt = 0;

	scanf("%d", &n);
	for (int i = 1; i <= n; i++) {
		if (i % 5 == 0) five_cnt++;
		if (i % 25 == 0) five_cnt++;
		if (i % 125 == 0) five_cnt++;
	}
	printf("%d", five_cnt);
}

// 0의 개수 = 2 x 5의 개수. ex) 2^4 * 3 * 5^2 = 10^2 * 2^2 * 3 = 1200 => 2개
// 2의 개수와 5의 개수 중 작은 것에 따라 10의 개수가 결정 됨. ex) 2가 4개, 5가 2개 => 10이 2개
// 보통 5의 개수가 작음. 따라서 5의 개수만 구하면 ok.
// n의 범위가 500이므로 5의 제곱수 범위는 125까지.