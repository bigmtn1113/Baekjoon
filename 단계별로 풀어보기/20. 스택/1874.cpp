#include <iostream>
#include <string>
#include <vector>

using namespace std;

int stack[100001];
int top;

void Push(int num) { stack[top++] = num; }
int Pop() { return stack[--top]; }

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int n, input_num, count = 0;
	vector<char> plus_minus_arr;
	bool is_valid = true;

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> input_num;

		for (int j = count; j < input_num; j++) {
			Push(j + 1);
			plus_minus_arr.push_back('+');
			count++;
		}
		if (Pop() == input_num) { plus_minus_arr.push_back('-'); }
		else { cout << "NO"; is_valid = false; break; }
	}

	if (is_valid)
		for (int i = 0; i < plus_minus_arr.size(); i++)
			cout << plus_minus_arr[i] << '\n';
}