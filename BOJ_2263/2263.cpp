#include <iostream>

using namespace std;

int inorder[100001];
int postorder[100001];
int in_idx[100001];			// inorder �ε��� �迭

void Preorder(int in_begin, int in_end, int post_begin, int post_end) {
	if (in_begin > in_end || post_begin > post_end) return;

	int root = postorder[post_end];		// postorder�� �� ������ ���Ұ� root

	cout << root << ' ';	// ��Ʈ
	Preorder(in_begin, in_idx[root] - 1, post_begin, post_begin + (in_idx[root] - in_begin) - 1);	// ����
	Preorder(in_idx[root] + 1, in_end, post_begin + (in_idx[root] - in_begin), post_end - 1);		// ������
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

		inorder:	����/ ��Ʈ/ ������
		postorder:	����/ ������/ ��Ʈ
		��Ʈ:		postorder�� �� �� ����

		inorder:	4 2/ 1/ 5 3 6 7
		postorder:	4 2/ 5 7 6 3/ 1
		��Ʈ:		1
		����:		4 2, 4 2
		������:		5 3 6 7, 5 7 6 3
		
		inorder:	4/ 2
		postorder:	4/ 2
		��Ʈ:		2
		����:		4, 4
		������:		x
		
		inorder:	4
		postorder:	4
		��Ʈ:		4
		����:		x
		������:		x
		
		inorder:	5/ 3/ 6 7
		postorder:	5/ 7 6/ 3
		��Ʈ:		3
		����:		5, 5
		������:		6 7, 7 6
		
		inorder:	5
		postorder:	5
		��Ʈ:		5
		����:		x
		������:		x
		
		inorder:	6/ 7
		postorder:	7/ 6
		��Ʈ:		6
		����:		x
		������:		7, 7

		inorder:	7
		postorder:	7
		��Ʈ:		7
		����:		x
		������:		x
	*/
}