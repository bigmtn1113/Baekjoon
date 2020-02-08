#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

class Schedule {
public:
	int begin, end;
};

bool compare(const Schedule &s1, const Schedule &s2) {
	if (s1.end < s2.end)
		return true;
	else if (s1.end == s2.end)
		return s1.begin < s2.begin;
	else
		return false;
}

int main() {
	int n, end_time, max = 1;
	Schedule schedule[100001];

	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		scanf("%d %d", &schedule[i].begin, &schedule[i].end);

	sort(schedule, schedule + n, compare);

	end_time = schedule[0].end;
	for (int i = 1; i < n; i++) {
		if (schedule[i].begin >= end_time) {
			end_time = schedule[i].end;
			max++;
		}
	}

	printf("%d", max);
}