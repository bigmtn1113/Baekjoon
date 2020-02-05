#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false)

		int a, b, v, result;

	cin >> a >> b >> v;
	result = (v - a) / (a - b);
	cout << ((v - a) % (a - b) == 0 ? result + 1 : result + 2);
}