#include <iostream>
#include <cstdio>		// 입력을 얼마나 받을 지 모르므로 scanf사용

using namespace std;

int tree[10001];

void Postorder(int left, int right) {
	if (left > right) return;

	int root = left;		// Preorder 특징 상 루트가 가장 먼저 출력되므로 left(가장 처음 인덱스)가 루트
	int last = right;

	while (left <= right && tree[root] > tree[++left]);		// 루트보다 작은 노드의 개수 파악하기

	Postorder(root + 1, left - 1);		// 왼쪽(루트보다 작은 노드들) 탐색
	Postorder(left, last);			// 오른쪽(루트보다 큰 노드들) 탐색
	printf("%d\n", tree[root]);		// 루트 출력
}

int main() {
	int node_cnt = 0;

	while (scanf_s("%d", &tree[++node_cnt]) > 0);		// EOF(-1)가 발생하기 전까지 무한정 입력 받기

	Postorder(1, node_cnt - 1);

	/*
		(루트 -> 왼쪽 -> 오른쪽)순서를 (왼쪽 -> 오른쪽 -> 루트)로 바꾸기

		왼쪽: 루트보다 작은 노드들
		오른쪽: 루트보다 큰 노드들
		루트: Preorder에서 가장 먼저 출력되는 노드

		=>
		1. Preorder에서 가장 먼저 출력되는 노드보다 작은 노드들 탐색
		2. Preorder에서 가장 먼저 출력되는 노드보다 큰 노드들 탐색
		3. 루트 출력
	*/
}

/*
	이진 검색 트리 만들어서 풀기

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
