#include <iostream>

using namespace std;

int n, k;
const int r = 1000000007;

unsigned long long Mod(unsigned long long num, int exponential) {
	if (exponential == 1) return num % r;

	unsigned long long temp = Mod(num, exponential / 2);
	if (exponential % 2 > 0) return ((temp % r * temp % r) % r * num % r) % r;
	else return (temp % r * temp % r) % r;

	// ab % r = (a % r * b % r) % r

	// ex)
	// 2^5 = 2^2 * 2^2 * 2    <- 지수가 홀수일 경우
	// 2^2 = 2^1 * 2^1        <- 지수가 짝수일 경우
	// 2^1 = 2                <- 지수가 1이면 return
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	unsigned long long n_fact = 1, k_fact = 1, n_k_fact = 1;

	cin >> n >> k;
	for (int i = 2; i <= n; ++i)
		n_fact = (n_fact % r * i % r) % r;
	for (int i = 2; i <= k; ++i)
		k_fact = (k_fact % r * i % r) % r;
	for (int i = 2; i <= n - k; ++i)
		n_k_fact = (n_k_fact % r * i % r) % r;

	cout << (n_fact * ((Mod(k_fact, r - 2) * Mod(n_k_fact, r - 2)) % r)) % r;

	// 나눗셈은 나머지 연산 불가
	// 페르마의 소정리 적용
	// (n! / (k! * (n - k)!)) % r = n! % r * (k! * (n - k)!)^(r - 2) % r
}