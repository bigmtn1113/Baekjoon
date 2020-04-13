#include <iostream>
#include <cstdio>		// �Է��� �󸶳� ���� �� �𸣹Ƿ� scanf���

using namespace std;

int tree[10001];

void Postorder(int left, int right) {
	if (left > right) return;

	int root = left;		// Preorder Ư¡ �� ��Ʈ�� ���� ���� ��µǹǷ� left(���� ó�� �ε���)�� ��Ʈ
	int last = right;

	while (left <= right && tree[root] > tree[++left]);		// ��Ʈ���� ���� ����� ���� �ľ��ϱ�

	Postorder(root + 1, left - 1);		// ����(��Ʈ���� ���� ����) Ž��
	Postorder(left, last);				// ������(��Ʈ���� ū ����) Ž��
	printf("%d\n", tree[root]);			// ��Ʈ ���
}

int main() {
	int node_cnt = 0;

	while (scanf_s("%d", &tree[++node_cnt]) > 0);		// EOF(-1)�� �߻��ϱ� ������ ������ �Է� �ޱ�

	Postorder(1, node_cnt - 1);

	/*
		(��Ʈ -> ���� -> ������)������ (���� -> ������ -> ��Ʈ)�� �ٲٱ�

		����: ��Ʈ���� ���� ����
		������: ��Ʈ���� ū ����
		��Ʈ: Preorder���� ���� ���� ��µǴ� ���

		=>
		1. Preorder���� ���� ���� ��µǴ� ��庸�� ���� ���� Ž��
		2. Preorder���� ���� ���� ��µǴ� ��庸�� ū ���� Ž��
		3. ��Ʈ ���
	*/
}

/*
	���� �˻� Ʈ�� ���� Ǯ��

	#include <iostream>
	#include <cstdio>

	using namespace std;

	int tree[1000001][2];

	void Postorder(int node) {
		if (!node) return;

		Postorder(tree[node][0]);
		Postorder(tree[node][1]);
		printf("%d\n", node);
	}

	int main() {
		int root, input;

		scanf("%d", &root);
		while (scanf("%d", &input) > 0) {
			int node = root;

			while (true) {
				if (input < node) {
					if (tree[node][0]) node = tree[node][0];
					else { tree[node][0] = input; break; }
				}
				else {
					if (tree[node][1]) node = tree[node][1];
					else { tree[node][1] = input; break; }
				}
			}
		}

		Postorder(root);
	}
*/