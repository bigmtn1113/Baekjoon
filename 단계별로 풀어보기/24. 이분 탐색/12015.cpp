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

	// result 배열에서 num이상의 값이 처음 나오는 인덱스 찾기
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

	// 10	->	빈 배열	->	10 추가	->	result = { 10 }
	// 20	->	10(마지막 원소) < 20	->	20 추가	->	result = { 10, 20 }
	// 10	->	20(마지막 원소) > 10	->	result 배열에서 10이상이 처음 나오는 인덱스 찾아서 값 교체	->	result = { 10, 20 }
	// 30	->	20(마지막 원소) < 30	->	30 추가	->	result = { 10, 20, 30 }
	// 20	->	30(마지막 원소) > 20	->	result 배열에서 20이상이 처음 나오는 인덱스 찾아서 값 교체	->	result = { 10, 20, 30 }
	// 50	->	30(마지막 원소) < 50	->	50 추가	->	result = { 10, 20, 30, 50 }
}