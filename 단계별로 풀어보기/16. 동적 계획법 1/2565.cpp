#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

class ElectricWire {
public:
	int a_pos, b_pos;
};

bool compare(const ElectricWire &w1, const ElectricWire &w2) {
	if (w1.a_pos <= w2.a_pos) return true;
	else return false;
}

int main() {
	int n, dp_max = 0;
	int dp[101];
	ElectricWire wire[101];

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d %d", &wire[i].a_pos, &wire[i].b_pos);

	sort(&wire[0], &wire[n], compare);

	fill_n(dp, n, 1);

	for (int i = 1; i < n; i++)
		for (int j = 0; j < i; j++)
			if (wire[i].b_pos > wire[j].b_pos && dp[i] <= dp[j])
				dp[i] = dp[j] + 1;

	for (int i = 0; i < n; i++)
		if (dp[i] > dp_max)
			dp_max = dp[i];

	printf("%d", n - dp_max);
}