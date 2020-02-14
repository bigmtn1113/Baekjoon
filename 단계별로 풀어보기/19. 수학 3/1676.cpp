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

// 0�� ���� = 2 x 5�� ����. ex) 2^4 * 3 * 5^2 = 10^2 * 2^2 * 3 = 1200 => 2��
// 2�� ������ 5�� ���� �� ���� �Ϳ� ���� 10�� ������ ���� ��. ex) 2�� 4��, 5�� 2�� => 10�� 2��
// ���� 5�� ������ ����. ���� 5�� ������ ���ϸ� ok.
// n�� ������ 500�̹Ƿ� 5�� ������ ������ 125����.