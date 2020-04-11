#include <iostream>

using namespace std;

char tree[27][2];

void Preorder(char node) {
	if (node == '.') return;

	cout << node;			// 루트
	Preorder(tree[node - 'A'][0]);	// 왼쪽
	Preorder(tree[node - 'A'][1]);	// 오른쪽
}

void Inorder(char node) {
	if (node == '.') return;

	Inorder(tree[node - 'A'][0]);	// 왼쪽
	cout << node;			// 루트
	Inorder(tree[node - 'A'][1]);	// 오른쪽
}

void Postorder(char node) {
	if (node == '.') return;

	Postorder(tree[node - 'A'][0]);	// 왼쪽
	Postorder(tree[node - 'A'][1]);	// 오른쪽
	cout << node;			// 루트
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n;

	cin >> n;
	for (int i = 0; i < n; ++i) {
		char node, left, right;

		cin >> node >> left >> right;
		tree[node - 'A'][0] = left;
		tree[node - 'A'][1] = right;
	}

	Preorder('A'); cout << '\n';
	Inorder('A'); cout << '\n';
	Postorder('A');
}

/*
	Dfs로 풀기

	#include <iostream>
	#include <vector>

	using namespace std;

	vector<char> preorder, inorder, postorder;
	char tree[27][2];
	bool visit[27];

	void Dfs(char node) {
		int node_index = node - 'A';
		visit[node_index] = true;

		char left_node = tree[node_index][0];
		char right_node = tree[node_index][1];

		preorder.push_back(node);
		if (left_node != '.' && !visit[left_node - 'A']) Dfs(left_node);
		inorder.push_back(node);
		if (right_node != '.' && !visit[right_node - 'A']) Dfs(right_node);
		postorder.push_back(node);
	}

	int main() {
		cin.tie(NULL);
		ios_base::sync_with_stdio(false);

		int n;

		cin >> n;
		for (int i = 0; i < n; ++i) {
			char node, left, right;

			cin >> node >> left >> right;
			tree[node - 'A'][0] = left;
			tree[node - 'A'][1] = right;
		}

		Dfs('A');

		for (int i = 0; i < n; ++i) cout << preorder[i]; cout << '\n';
		for (int i = 0; i < n; ++i) cout << inorder[i]; cout << '\n';
		for (int i = 0; i < n; ++i) cout << postorder[i];
	}
*/
