#include <iostream>

using namespace std;

int heap[100001];
int heap_size;

void InsertMaxHeap(int num) {
	int temp;

	heap[++heap_size] = num;
	for (int i = heap_size; i > 1; i /= 2) {
		if (heap[i] <= heap[i / 2]) break;

		else {
			temp = heap[i];
			heap[i] = heap[i / 2];
			heap[i / 2] = temp;
		}
	}

	// 힙 마지막에 원소를 삽입
	// 삽입한 원소가 부모 원소보다 크면 부모 원소와 교환
	// 가장 큰 원소가 최상위 부모 원소가 됨
}

int DeleteMaxHeap() {
	if (!heap_size) return 0;

	int temp, result = heap[1];

	heap[1] = heap[heap_size];
	heap[heap_size--] = 0;

	for (int i = 1; i * 2 <= heap_size;) {
		if (heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]) break;

		if (heap[i * 2] > heap[i * 2 + 1]) {
			temp = heap[i];
			heap[i] = heap[i * 2];
			heap[i * 2] = temp;
			i *= 2;
		}
		else {
			temp = heap[i];
			heap[i] = heap[i * 2 + 1];
			heap[i * 2 + 1] = temp;
			i = i * 2 + 1;
		}
	}

	return result;

	// 힙 마지막 원소를 힙 맨 처음에 삽입
	// 삽입한 원소를 자식 원소 중 큰 원소와 교환
	// 최상위 부모 원소가 가장 크므로 return
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input;

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;

		if (input) InsertMaxHeap(input);
		else cout << DeleteMaxHeap() << '\n';
	}
}