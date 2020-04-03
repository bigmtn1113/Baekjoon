#include <iostream>

#define ABS(X) ((X < 0) ? (X * -1) : (X))

using namespace std;

int n, w;
int accident[1001][2];
int dp[1001][1001];		// dp[a][b] = 1번 차가 마지막으로 해결한 사건이 a, 2번 차가 마지막으로 해결한 사건이 b일 때의 최소 이동거리

int Solution(int car1, int car2) {
	if (car1 == w || car2 == w)
		return 0;

	if (dp[car1][car2] != 0)
		return dp[car1][car2];

	int next = (car1 > car2) ? car1 + 1 : car2 + 1;		// 다음 사건
	int dist1, dist2;

	if (car1 == 0)
		dist1 = ABS((accident[next][0] - 1)) + ABS((accident[next][1] - 1));		// 1번 차가 처음위치(1, 1)에 있을 경우
	else
		dist1 = ABS((accident[next][0] - accident[car1][0])) + ABS((accident[next][1] - accident[car1][1]));		// 다음 사건 - 1번 차 위치

	if (car2 == 0)
		dist2 = ABS((accident[next][0] - n)) + ABS((accident[next][1] - n));		// 2번 차가 처음위치(6, 6)에 있을 경우
	else
		dist2 = ABS((accident[next][0] - accident[car2][0])) + ABS((accident[next][1] - accident[car2][1]));		// 다음 사건 - 2번 차 위치

	int case_car1 = Solution(next, car2) + dist1;		// 1번 차를 다음 사건 현장으로 출동했을 때의 이동거리
	int case_car2 = Solution(car1, next) + dist2;		// 2번 차를 다음 사건 현장으로 출동했을 때의 이동거리

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