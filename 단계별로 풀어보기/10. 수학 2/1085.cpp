#include <iostream>

using namespace std;

int main() {
	cin.tie(NULL);
	ios_base::sync_with_stdio(false);

	int x, y, w, h;

	cin >> x >> y >> w >> h;
	int x_0 = x - 0, w_x = w - x, y_0 = y - 0, h_y = h - y;

	if (x_0 <= w_x && x_0 <= y_0 && x_0 <= h_y) { cout << x_0; return 0; }
	if (w_x <= x_0 && w_x <= y_0 && w_x <= h_y) { cout << w_x; return 0; }
	if (y_0 <= w_x && y_0 <= x_0 && y_0 <= h_y) { cout << y_0; return 0; }
	if (h_y <= w_x && h_y <= y_0 && h_y <= x_0) { cout << h_y; return 0; }
}