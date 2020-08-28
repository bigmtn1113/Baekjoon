#include <iostream>

using namespace std;

int n;
int a[1000001], result[1000001];

int LowerBound(int begin, int end, int num) {
	int mid;

	while (begin < end) {
		mid = (begin + end) / 2;
		if (num > result[mid]) begin = mid + 1;
		else end = mid;
	}

	return end;

	// result �迭���� num�̻��� ���� ó�� ������ �ε��� ã��
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int result_index = 0;

	cin >> n;
	for (int i = 0; i < n; ++i)
		cin >> a[i];

	result[0] = a[0];
	for (int i = 1; i < n; ++i) {
		if (result[result_index] < a[i])
			result[++result_index] = a[i];
		else
			result[LowerBound(0, result_index + 1, a[i])] = a[i];
	}

	cout << result_index + 1;

	// ex) 10 20 10 30 20 50

	// 10	->	�� �迭	->	10 �߰�	->	result = { 10 }
	// 20	->	10(������ ����) < 20	->	20 �߰�	->	result = { 10, 20 }
	// 10	->	20(������ ����) > 10	->	result �迭���� 10�̻��� ó�� ������ �ε��� ã�Ƽ� �� ��ü	->	result = { 10, 20 }
	// 30	->	20(������ ����) < 30	->	30 �߰�	->	result = { 10, 20, 30 }
	// 20	->	30(������ ����) > 20	->	result �迭���� 20�̻��� ó�� ������ �ε��� ã�Ƽ� �� ��ü	->	result = { 10, 20, 30 }
	// 50	->	30(������ ����) < 50	->	50 �߰�	->	result = { 10, 20, 30, 50 }
}