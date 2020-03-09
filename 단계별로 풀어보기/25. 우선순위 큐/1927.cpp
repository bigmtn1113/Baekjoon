#include <iostream>

using namespace std;

int heap[100001];
int heap_size;

void Swap(int &num1, int &num2) {
	int temp;

	temp = num1;
	num1 = num2;
	num2 = temp;
}

void InsertMinHeap(int num) {
	heap[++heap_size] = num;
	for (int i = heap_size; i > 1; i /= 2) {
		if (heap[i] >= heap[i / 2]) break;
		else Swap(heap[i], heap[i / 2]);
	}

	// �� �������� ���Ҹ� ����
	// ������ ���Ұ� �θ� ���Һ��� ������ �θ� ���ҿ� ��ȯ
	// ���� ���� ���Ұ� �ֻ��� �θ� ���Ұ� ��
}

int DeleteMinHeap() {
	if (!heap_size) return 0;

	int result = heap[1];

	heap[1] = heap[heap_size];
	heap[heap_size--] = 0;

	for (int i = 1; i * 2 <= heap_size;) {
		if (heap[i] < heap[i * 2] && heap[i] < heap[i * 2 + 1]) break;

		if (!heap[i * 2 + 1]) {
			if (heap[i] < heap[i * 2]) break;
			else { Swap(heap[i], heap[i * 2]); break; }
		}

		if (heap[i * 2] > heap[i * 2 + 1]) {
			Swap(heap[i], heap[i * 2 + 1]);
			i = i * 2 + 1;
		}
		else {
			Swap(heap[i], heap[i * 2]);
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

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> input;

		if (input) InsertMinHeap(input);
		else cout << DeleteMinHeap() << '\n';
	}
}