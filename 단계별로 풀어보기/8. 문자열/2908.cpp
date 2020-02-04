#include <iostream>
#include <string>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	string a, b;
	char temp;
	int ia, ib;

	cin >> a >> b;

	temp = a[0];
	a[0] = a[2];
	a[2] = temp;

	temp = b[0];
	b[0] = b[2];
	b[2] = temp;

	ia = stoi(a);
	ib = stoi(b);

	cout << (ia > ib ? ia : ib);
}