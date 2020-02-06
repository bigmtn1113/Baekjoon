#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
	int n, most = 1, most_value, count = 1, temp, max, min;
	double avg = 0;
	int arr[500001];
	bool is_first = true;

	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		avg += arr[i];
	}

	max = arr[0];
	min = arr[0];

	for (int i = 1; i < n; i++) {
		if (max < arr[i]) max = arr[i];
		if (min > arr[i]) min = arr[i];
	}

	sort(arr, arr + n);

	temp = arr[0];
	most_value = arr[0];
	for (int i = 1; i < n; i++) {
		if (temp == arr[i]) count++;
		if (count > most) most = count;
		if (temp != arr[i]) {
			count = 1;
			temp = arr[i];
		}
	}

	temp = arr[0];
	count = 1;
	for (int i = 1; i < n; i++) {
		if (temp == arr[i]) count++;
		if (count == most) {
			if (!is_first) {
				most_value = arr[i - 1];
				break;
			}
			else {
				is_first = false;
				most_value = arr[i - 1];
				count = 1;
			}
		}
		if (temp != arr[i]) {
			count = 1;
			temp = arr[i];
		}
	}

	printf("%d\n", (int)round(avg / n));
	printf("%d\n", arr[n / 2]);
	printf("%d\n", most_value);
	printf("%d", max - min);
}