#include <iostream>
#include <cstdio>

using namespace std;

int main() {
	int n, m, sum = 0;
	int card[101];

	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%d", &card[i]);

	for (int i = 0; i < n; i++)
		for (int j = i + 1; j < n; j++)
			for (int k = j + 1; k < n; k++)
				if ((card[i] + card[j] + card[k] > sum) && card[i] + card[j] + card[k] <= m)
					sum = card[i] + card[j] + card[k];

	printf("%d", sum);
}