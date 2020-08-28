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

	// �� �������� ���Ҹ� ����
	// ������ ���Ұ� �θ� ���Һ��� ũ�� �θ� ���ҿ� ��ȯ
	// ���� ū ���Ұ� �ֻ��� �θ� ���Ұ� ��
}

void InsertMinHeap(int num) {
	min_heap[++min_heap_size] = num;
	for (int i = min_heap_size; i > 1; i /= 2) {
		if (min_heap[i] >= min_heap[i / 2]) break;
		else Swap(min_heap[i], min_heap[i / 2]);
	}

	// �� �������� ���Ҹ� ����
	// ������ ���Ұ� �θ� ���Һ��� ������ �θ� ���ҿ� ��ȯ
	// ���� ���� ���Ұ� �ֻ��� �θ� ���Ұ� ��
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

	// �� ������ ���Ҹ� �� �� ó���� ����
	// ������ ���Ҹ� �ڽ� ���� �� ū ���ҿ� ��ȯ
	// �ֻ��� �θ� ���Ұ� ���� ũ�Ƿ� return
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

	// �� ������ ���Ҹ� �� �� ó���� ����
	// ������ ���Ҹ� �ڽ� ���� �� ���� ���ҿ� ��ȯ
	// �ֻ��� �θ� ���Ұ� ���� �����Ƿ� return
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

// ������������ ���ĵ� �迭������ �߾Ӱ��� ����
// [ó�� ~ �߾�]���� �߾Ӱ��� ���� ũ�� [�߾� ~ ��]���� �߾Ӱ��� ���� ����

// [ó�� ~ �߾�]�� max_heap, [�߾� ~ ��]�� min_heap���� ����
// �׷��Ƿ� max_heap�� ��Ʈ ���Ҵ� min_heap�� ��Ʈ ���Һ��� �۰ų� ���ƾ� ��. ũ�� �� ���ҳ��� ��ȯ.
// max_heap�� ��Ʈ ���Ұ� ���������� �߾Ӱ�.

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


// �ٸ� Ǯ��
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