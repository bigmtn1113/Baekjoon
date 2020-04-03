#include <iostream>

#define ABS(X) ((X < 0) ? (X * -1) : (X))

using namespace std;

int n, w;
int accident[1001][2];
int dp[1001][1001];		// dp[a][b] = 1�� ���� ���������� �ذ��� ����� a, 2�� ���� ���������� �ذ��� ����� b�� ���� �ּ� �̵��Ÿ�

int Solution(int car1, int car2) {
	if (car1 == w || car2 == w)
		return 0;

	if (dp[car1][car2] != 0)
		return dp[car1][car2];

	int next = (car1 > car2) ? car1 + 1 : car2 + 1;		// ���� ���
	int dist1, dist2;

	if (car1 == 0)
		dist1 = ABS((accident[next][0] - 1)) + ABS((accident[next][1] - 1));		// 1�� ���� ó����ġ(1, 1)�� ���� ���
	else
		dist1 = ABS((accident[next][0] - accident[car1][0])) + ABS((accident[next][1] - accident[car1][1]));		// ���� ��� - 1�� �� ��ġ

	if (car2 == 0)
		dist2 = ABS((accident[next][0] - n)) + ABS((accident[next][1] - n));		// 2�� ���� ó����ġ(6, 6)�� ���� ���
	else
		dist2 = ABS((accident[next][0] - accident[car2][0])) + ABS((accident[next][1] - accident[car2][1]));		// ���� ��� - 2�� �� ��ġ

	int case_car1 = Solution(next, car2) + dist1;		// 1�� ���� ���� ��� �������� �⵿���� ���� �̵��Ÿ�
	int case_car2 = Solution(car1, next) + dist2;		// 2�� ���� ���� ��� �������� �⵿���� ���� �̵��Ÿ�

	return dp[car1][car2] = (case_car1 < case_car2) ? case_car1 : case_car2;
}

void track(int car1, int car2) {
	if (car1 == w || car2 == w)
		return;

	int next = (car1 > car2) ? car1 + 1 : car2 + 1;
	int dist1, dist2;

	if (car1 == 0)
		dist1 = ABS((accident[next][0] - 1)) + ABS((accident[next][1] - 1));
	else
		dist1 = ABS((accident[next][0] - accident[car1][0])) + ABS((accident[next][1] - accident[car1][1]));

	if (car2 == 0)
		dist2 = ABS((accident[next][0] - n)) + ABS((accident[next][1] - n));
	else
		dist2 = ABS((accident[next][0] - accident[car2][0])) + ABS((accident[next][1] - accident[car2][1]));

	if (dp[next][car2] + dist1 < dp[car1][next] + dist2) {
		cout << 1 << '\n';
		track(next, car2);
	}
	else {
		cout << 2 << '\n';
		track(car1, next);
	}

	return;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);


	cin >> n >> w;
	for (int i = 1; i <= w; ++i)
		cin >> accident[i][0] >> accident[i][1];

	cout << Solution(0, 0) << '\n';
	track(0, 0);
}