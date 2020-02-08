#include <iostream>
#include <string>

using namespace std;

int main() {
	string expression, temp;
	char plus_or_minus = '\0';
	int num, sum = 0;
	bool minus_sw = false;

	cin >> expression;

	for (int i = 0; i <= expression.length(); i++) {
		if (expression[i] != '+' && expression[i] != '-' && expression[i] != '\0')
			temp += expression[i];
		else {
			num = stoi(temp);
			temp = "";

			if (plus_or_minus == '\0') {
				plus_or_minus = expression[i];
				sum = num;
			}
			else {
				if (!minus_sw) {
					if (plus_or_minus == '+')
						sum += num;
					else {
						sum -= num;
						minus_sw = true;
					}
				}
				else
					sum -= num;

				plus_or_minus = expression[i];
			}
		}
	}
	printf("%d", sum);
}