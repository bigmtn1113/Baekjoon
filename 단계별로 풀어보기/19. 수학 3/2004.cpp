#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n, m;
	int n_cnt[2] = {}, m_cnt[2] = {}, n_m_cnt[2] = {};
	long long i;

	scanf("%d %d", &n, &m);

	for (i = 2; i <= n; i *= 2)
		n_cnt[0] += n / i;
	for (i = 5; i <= n; i *= 5)
		n_cnt[1] += n / i;

	for (i = 2; i <= m; i *= 2)
		m_cnt[0] += m / i;
	for (i = 5; i <= m; i *= 5)
		m_cnt[1] += m / i;

	for (i = 2; i <= n - m; i *= 2)
		n_m_cnt[0] += (n - m) / i;
	for (i = 5; i <= n - m; i *= 5)
		n_m_cnt[1] += (n - m) / i;

	printf("%d", (n_cnt[0] - m_cnt[0] - n_m_cnt[0]) < (n_cnt[1] - m_cnt[1] - n_m_cnt[1]) ? (n_cnt[0] - m_cnt[0] - n_m_cnt[0]) : (n_cnt[1] - m_cnt[1] - n_m_cnt[1]));
}

// n = 10, m = 8

// 10! = 2�� ���� 8, 5�� ���� 2
// 10/2 + 10/4 + 10/8 = 8, 10/5 = 2

// 8! = 2�� ���� 7, 5�� ���� 1
// 8/2 + 8/4 + 8/8 = 7, 8/5 = 1

// 2! = 2�� ���� 1, 5�� ���� 0
// 2/2 = 1

// 8-7-1 = 0, 2-1 = 1
// 2�� ���� 5�� ���Ƽ� 10�� ���� ����. => 0�� ���� = 0