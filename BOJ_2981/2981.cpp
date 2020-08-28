#include <iostream>
#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int GCD(int a, int b) {
	return a % b == 0 ? b : GCD(b, a % b);
}

int main() {
	int n, gcd, index;
	int num[101];
	vector<int> m;

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d", &num[i]);

	sort(num, num + n);

	gcd = num[1] - num[0];
	for (int i = 2; i < n; i++)
		gcd = GCD(gcd, num[i] - num[i - 1]);

	for (index = 2; index * index <= gcd; index++) {
		if (gcd % index == 0) {
			m.push_back(index);
			m.push_back(gcd / index);
		}
	}
	m.push_back(gcd);
	sort(m.begin(), m.end());
	m.erase(unique(m.begin(), m.end()), m.end());

	sort(m.begin(), m.end());

	for (int i = 0; i < m.size(); i++)
		printf("%d ", m[i]);
}