#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

class Point {
public:
	int x, y;
};

bool compare(const Point &p1, const Point &p2) {
	if (p1.x < p2.x) return true;
	else if (p1.x == p2.x) return p1.y < p2.y;
	else return false;
}

int main() {
	int n;
	Point p[100001];

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d %d", &p[i].x, &p[i].y);

	sort(&p[0], &p[n], compare);

	for (int i = 0; i < n; i++)
		printf("%d %d\n", p[i].x, p[i].y);
}