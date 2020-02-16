#include <iostream>
#include <string>

using namespace std;

int stack[100001];
int top = 0;

void Push(int num) { stack[top++] = num; }
void Pop() { --top; }

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int k, num, sum = 0;

	cin >> k;

	for (int i = 0; i < k; i++) {
		cin >> num;
		num == 0 ? Pop() : Push(num);
	}
	for (int i = 0; i < top; i++)
		sum += stack[i];

	cout << sum;
}