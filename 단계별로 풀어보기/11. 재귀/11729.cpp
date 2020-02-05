#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

vector<pair<int, int>> v;

void hanoi(int n, int from, int by, int to)
{
	if (n == 1) v.push_back({ from, to });
	else {
		hanoi(n - 1, from, to, by);
		v.push_back({ from, to });
		hanoi(n - 1, by, from, to);
	}
}

int main() {
	int n;

	scanf("%d", &n);
	hanoi(n, 1, 2, 3);
	printf("%d\n", v.size());
	for (int i = 0; i < v.size(); i++)
		printf("%d %d\n", v[i].first, v[i].second);
}