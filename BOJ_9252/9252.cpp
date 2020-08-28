#include <iostream>
#include <string>
#include <vector>

#define MAX(X, Y) ((X > Y) ? (X) : (Y))

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string str1, str2;
	int len1, len2;
	int dp[101][101] = {};

	cin >> str1 >> str2;
	len1 = str1.size();
	len2 = str2.size();

	/*
		ex) abd abc
			a b c
		  0 0 0 0
		a 0 1 1 1
		b 0 1 2 2
		d 0 1 2 2
	 
		dp[3][3] = 2
	 */
	for (int i = 1; i <= len1; ++i) {
		for (int j = 1; j <= len2; ++j) {
			if (str1[i - 1] == str2[j - 1])
				dp[i][j] = dp[i - 1][j - 1] + 1;
			else
				dp[i][j] = MAX(dp[i - 1][j], dp[i][j - 1]);
		}
	}

	cout << dp[len1][len2] << '\n';

	/*
			a b c
		  0 0 0 0
		a 0 1 1 1
		b 0 1 2 2
		d 0 1 2 2

		result = ba
	*/
	vector<char> result;

	while (len1 >= 1 && len2 >= 1) {
		if (dp[len1][len2] == dp[len1 - 1][len2])
			--len1;
		else if (dp[len1][len2] == dp[len1][len2 - 1])
			--len2;
		else {
			result.push_back(str1[len1 - 1]);
			--len1;
			--len2;
		}
	}

	/*
		ba를 거꾸로 출력
		a -> b
	*/
	for (int i = result.size() - 1; i >= 0; --i)
		cout << result[i];
}