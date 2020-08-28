#define	_USE_MATH_DEFINES

#include <iostream>
#include <cstdio>
#include <cmath>

using namespace std;

int main() {
	double r;

	scanf("%lf", &r);
	printf("%lf\n", r * r * M_PI);
	printf("%lf", 2 * r * r);
}