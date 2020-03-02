#include <iostream>
#include <cmath>

using namespace std;

int a, b, c;

int Mod(int num) {
	if (num == 1) return a % c;

	unsigned long long temp = Mod(num / 2);
	if (num % 2 > 0) return ((temp % c * temp % c) % c * a % c) % c;
	else return (temp % c * temp % c) % c;
}

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> a >> b >> c;

	cout << Mod(b);
}