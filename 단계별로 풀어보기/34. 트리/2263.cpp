#include <iostream>

using namespace std;

int inorder[100001];
int postorder[100001];
int in_idx[100001];			// inorder 인덱스 배열

void Preorder(int in_begin, int in_end, int post_begin, int post_end) {
	if (in_begin > in_end || post_begin > post_end) return;

	int root = postorder[post_end];		// postorder의 맨 마지막 원소가 root

	cout << root << ' ';	// 루트
	Preorder(in_begin, in_idx[root] - 1, post_begin, post_begin + (in_idx[root] - in_begin) - 1);	// 왼쪽
	Preorder(in_idx[root] + 1, in_end, post_begin + (in_idx[root] - in_begin), post_end - 1);		// 오른쪽
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 0; i < n; ++i) {
		cin >> inorder[i];
		in_idx[inorder[i]] = i;
	}

	for (int i = 0; i < n; ++i)
		cin >> postorder[i];

	Preorder(0, n - 1, 0, n - 1);

	/*
		ex)
		7
		4 2 1 5 3 6 7
		4 2 5 7 6 3 1

		inorder:	왼쪽/ 루트/ 오른쪽
		postorder:	왼쪽/ 오른쪽/ 루트
		루트:		postorder의 맨 끝 원소

		inorder:	4 2/ 1/ 5 3 6 7
		postorder:	4 2/ 5 7 6 3/ 1
		루트:		1
		왼쪽:		4 2, 4 2
		오른쪽:		5 3 6 7, 5 7 6 3
		
		inorder:	4/ 2
		postorder:	4/ 2
		루트:		2
		왼쪽:		4, 4
		오른쪽:		x
		
		inorder:	4
		postorder:	4
		루트:		4
		왼쪽:		x
		오른쪽:		x
		
		inorder:	5/ 3/ 6 7
		postorder:	5/ 7 6/ 3
		루트:		3
		왼쪽:		5, 5
		오른쪽:		6 7, 7 6
		
		inorder:	5
		postorder:	5
		루트:		5
		왼쪽:		x
		오른쪽:		x
		
		inorder:	6/ 7
		postorder:	7/ 6
		루트:		6
		왼쪽:		x
		오른쪽:		7, 7

		inorder:	7
		postorder:	7
		루트:		7
		왼쪽:		x
		오른쪽:		x
	*/
}