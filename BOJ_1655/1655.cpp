#include <iostream>

using namespace std;

int max_heap[100001], min_heap[100001];
int max_heap_size, min_heap_size;

void Swap(int &num1, int &num2) {
	int temp;

	temp = num1;
	num1 = num2;
	num2 = temp;
}

void InsertMaxHeap(int num) {
	max_heap[++max_heap_size] = num;
	for (int i = max_heap_size; i > 1; i /= 2) {
		if (max_heap[i] <= max_heap[i / 2]) break;
		else Swap(max_heap[i], max_heap[i / 2]);
	}

	// 힙 마지막에 원소를 삽입
	// 삽입한 원소가 부모 원소보다 크면 부모 원소와 교환
	// 가장 큰 원소가 최상위 부모 원소가 됨
}

void InsertMinHeap(int num) {
	min_heap[++min_heap_size] = num;
	for (int i = min_heap_size; i > 1; i /= 2) {
		if (min_heap[i] >= min_heap[i / 2]) break;
		else Swap(min_heap[i], min_heap[i / 2]);
	}

	// 힙 마지막에 원소를 삽입
	// 삽입한 원소가 부모 원소보다 작으면 부모 원소와 교환
	// 가장 작은 원소가 최상위 부모 원소가 됨
}

int DeleteMaxHeap() {
	if (!max_heap_size) return 0;

	int result = max_heap[1];

	max_heap[1] = max_heap[max_heap_size--];
	for (int i = 1; i * 2 <= max_heap_size;) {
		if (max_heap[i] > max_heap[i * 2] && max_heap[i] > max_heap[i * 2 + 1]) break;

		if (max_heap[i * 2] > max_heap[i * 2 + 1]) {
			Swap(max_heap[i], max_heap[i * 2]);
			i *= 2;
		}
		else {
			Swap(max_heap[i], max_heap[i * 2 + 1]);
			i = i * 2 + 1;
		}
	}

	return result;

	// 힙 마지막 원소를 힙 맨 처음에 삽입
	// 삽입한 원소를 자식 원소 중 큰 원소와 교환
	// 최상위 부모 원소가 가장 크므로 return
}

int DeleteMinHeap() {
	if (!min_heap_size) return 0;

	int result = min_heap[1];

	min_heap[1] = min_heap[min_heap_size--];
	for (int i = 1; i * 2 <= min_heap_size;) {
		if (min_heap[i] < min_heap[i * 2] && min_heap[i] < min_heap[i * 2 + 1]) break;

		if (min_heap[i * 2] > min_heap[i * 2 + 1]) {
			Swap(min_heap[i], min_heap[i * 2 + 1]);
			i = i * 2 + 1;
		}
		else {
			Swap(min_heap[i], min_heap[i * 2]);
			i *= 2;
		}
	}

	return result;

	// 힙 마지막 원소를 힙 맨 처음에 삽입
	// 삽입한 원소를 자식 원소 중 작은 원소와 교환
	// 최상위 부모 원소가 가장 작으므로 return
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input;
	int max_top, min_top;

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;

		if (max_heap_size == min_heap_size) InsertMaxHeap(input);
		else InsertMinHeap(input);

		if (max_heap_size && min_heap_size && min_heap[1] < max_heap[1]) {
			max_top = max_heap[1];
			min_top = min_heap[1];
			DeleteMaxHeap();
			DeleteMinHeap();
			InsertMaxHeap(min_top);
			InsertMinHeap(max_top);
		}

		cout << max_heap[1] << '\n';
	}
}

// 오름차순으로 정렬된 배열에서의 중앙값의 성질
// [처음 ~ 중앙]에서 중앙값은 제일 크고 [중앙 ~ 끝]에서 중앙값은 제일 작음

// [처음 ~ 중앙]을 max_heap, [중앙 ~ 끝]을 min_heap으로 구현
// 그러므로 max_heap의 루트 원소는 min_heap의 루트 원소보다 작거나 같아야 함. 크면 두 원소끼리 교환.
// max_heap의 루트 원소가 최종적으로 중앙값.

// ex) 1 5 2 10 -99 7 5 4
// 1	->	max_heap = { 1 }, min_heap = { }	->	1
// 5	->	max_heap = { 1 }, min_heap = { 5 }	->	1
// 2	->	max_heap = { 2, 1 }, min_heap = { 5 }	->	2
// 10	->	max_heap = { 2, 1 }, min_heap = { 5, 10 }	->	2
// -99	->	max_heap = { 2, 1, -99 }, min_heap = { 5, 10 }	->	2
// 7	->	max_heap = { 2, 1, -99 }, min_heap = { 5, 10, 7 }	->	2
// 5	->	max_heap = { 5, 2, -99, 1 }, min_heap = { 5, 10, 7 }	->	5
// 4	->	max_heap = { 5, 2, -99, 1 }, min_heap = { 4, 5, 7, 10 }
//		->	max_heap = { 4, 2, -99, 1 }, min_heap = { 5, 5, 7, 10 }	->	4


// 다른 풀이
/*
#include <iostream>
#include <queue>
#include <functional>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input;
	int max_top, min_top;
	priority_queue<int> max_heap;
	priority_queue<int, vector<int>, greater<int>> min_heap;

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;
		
		if (max_heap.size() == min_heap.size()) max_heap.push(input);
		else min_heap.push(input);

		if (!max_heap.empty() && !min_heap.empty() && min_heap.top() < max_heap.top()) {
			max_top = max_heap.top();
			min_top = min_heap.top();
			max_heap.pop();
			min_heap.pop();
			max_heap.push(min_top);
			min_heap.push(max_top);
		}

		cout << max_heap.top() << '\n';
	}
}
*/