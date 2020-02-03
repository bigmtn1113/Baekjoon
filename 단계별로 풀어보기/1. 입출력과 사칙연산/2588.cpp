#include <iostream>

using namespace std;

int main() {
	int A, B;
	int one, two, three;

	cin >> A >> B;

	one = B / 100;
	two = (B % 100) / 10;
	three = B % 10;

	cout << A * three << endl;
	cout << A * two << endl;
	cout << A * one << endl;
	cout << A * B;
}