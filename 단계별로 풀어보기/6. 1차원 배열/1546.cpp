#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, max = -0x7fffffff;
	int score[1001];
	float avg = 0;

	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> score[i];
		if (score[i] > max)
			max = score[i];
	}
	for (int i = 0; i < N; i++)
		avg += (float)score[i] / max;

	cout << avg / N * 100;
}