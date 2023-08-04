// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=395
// 제출 링크 : 
// 소프티어 금고털이

// 쉬어갈겸 푸는 level 2문제

/*
일곱번째 레벨 2 문제

여섯번째 문제가 너무 쉬워서 조금더 어려웠으면 싶다.
참 직관적인 냅색문제 같았다.
그런데, 넣는 물건이.. 무게당 가격이라니? 순식간에 탐욕법 문제가 되었다..
*/

#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	// 배낭 무게, 귀금속 종류
	int w, n;
	cin >> w >> n;

	// pair<무게당 가격, 금속의 무게>
	vector<pair<int, int>> metals;
	for (int i = 0; i < n; i++) {
		pair<int, int> p;
		cin >> p.second >> p.first;
		metals.push_back(p);
	}

	sort(metals.begin(), metals.end());

	// 배낭에 담을 수 있는 가장 비싼 가격
	int price = 0;
	while (w > 0 && n > 0) {
		pair<int, int> metal = metals.back();
		metals.pop_back();

		if (w < metal.second) {
			metal.second = w;
		}

		w -= metal.second;
		price += metal.second * metal.first;

		n--;

		// cout << price  << ' ' << metal.second() << ' ' << w << ' ' << n << endl;
	}

	cout << price << endl;

	return 0;
}