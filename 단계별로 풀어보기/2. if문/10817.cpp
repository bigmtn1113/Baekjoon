#include <iostream>

using namespace std;

int main() {
	int A, B, C;

	cin >> A >> B >> C;

	if ((B >= A && A >= C) || (C >= A && A >= B))
		cout << A;
	else if ((A >= B && B >= C) || (C >= B && B >= A))
		cout << B;
	else
		cout << C;
}