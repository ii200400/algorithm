// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=631
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_236965&psProblemId=631
// 소프티어 [21년 재직자 대회 본선] 트럭

// 궁금해서 풀어보는 레벨 4 문제

/*
어.. 너무 어려운데.. 일단 풀이 방법부터 작성해보겠다.

1. 모든 소비자의 제안을 크기 오름차순으로 정렬한다. 자료형은 vector<int[]<제안 크기, 제안 가격, 소비자 넘버>>
2. 시나리오 매출도 오름차순으로 정렬한다.
3. 각 소비자의 제안 중 가장 좋은 제안을 저장하는 배열과 제안의 가격 합, 크기 변수를 만들고
	가격 합이 가장 작은 시나리오 매출을 도달할 때까지 소비자의 제안을 정렬한 것을 살펴본다.
4. 가격 합이 시나리오 매출에 도달했다면 해당 매출과 크기를 키:값으로 map 자료형에 저장하고 
	이런 방식으로 모든 시나리오 매출에 대해서도 똑같이 진행한다.
5. 저장한 map을 기반으로 예제 순서에 맞게 출력을 한다.

-- 1차 시도 -- 
오! 절반이 정답, 절반이 런타임 에러이다.
.. 그런데 어디서 생기는 에러지..?

int* best 의 크기를 사용자 수인 n이 아니라 시나리오 수인 m을 넣었다;
이것만 고쳐주니 정답! 기부니가 좋다!
속도도 가장 느린 케이스가 0.55초 정도로 빠른 것 같다!

*/

#include<iostream>
#include<vector>
#include<map>
#include <algorithm>

using namespace std;

int main(int argc, char** argv)
{
	// 소비자 수와 소비자의 제안들<제안 크기, 제안 비용, 소비자 번호>
	int n;
	vector<vector<int>> consumers;
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		// 소비자의 제안 수
		int a;
		cin >> a;

		for (; a > 0; a--) {
			vector<int> v;
			int temp;
			cin >> temp;
			v.push_back(temp);
			cin >> temp;
			v.push_back(temp);
			v.push_back(i);

			consumers.push_back(v);
		}
	}

	/*
	디버깅용
	for (auto i : consumers) {
		cout << i[0] << ' ' << i[1] << ' ' << i[2] << endl;
	}
	*/

	// 소비자의 제안을 크기순으로 정렬한다.
	sort(consumers.begin(), consumers.end());

	// 시나리오 수
	int m;
	cin >> m;

	// 시나리오의 각 비용(정렬 안 된것과 된 것)
	vector<int> scen;
	vector<int> scenSort;
	for (int i = 0; i < m; i++) {
		int temp;
		cin >> temp;

		scen.push_back(temp);
		scenSort.push_back(temp);
	}

	sort(scenSort.begin(), scenSort.end());

	// 소비자별 최대 가격
	int* best = new int[n] {0};
	// 시나리오 자동차 크기, 소비자 최대 비용, 소비자 제안 인덱스
	int carSize = 0, priceSum = 0, conIdx = 0;
	// 시나리오 별 신차의 최소의 크기
	map<int, int> scenMap;

	// 시나리오의 비용을 하나씩 본다.
	for (int i = 0; i < m; i++) {
		// cout << priceSum << ' ' << carSize << ' ' << scenSort[i] << endl;

		// 이미 비용이 시나리오 비용보다 크다면 map에 저장한다.
		if (priceSum >= scenSort[i]) {
			scenMap[scenSort[i]] = carSize;
			continue;
		}

		// 그 비용을 넘길 때까지, 소비자의 제안이 남아 있을 때까지 살펴본다.
		while (priceSum < scenSort[i] && conIdx < consumers.size()) {
			int size = consumers[conIdx][0], price = consumers[conIdx][1], conNum = consumers[conIdx][2];
			conIdx++;

			// 소비자의 제안이 이전 제안보다 비용이 높다면, 그것으로 대체한다.
			if (price > best[conNum]) {
				priceSum += price - best[conNum];
				best[conNum] = price;
				carSize = size;

				// 오른 총 비용이 시나리오 비용보다 크다면 map에 저장한다.
				if (priceSum >= scenSort[i]) {
					scenMap[scenSort[i]] = carSize;
					break;
				}
			}
		}
	}

	// map에 저장된 내용을 순서에 맞게 출력한다.
	for (int i = 0; i < m; i++) {
		if (scenMap.find(scen[i]) != scenMap.end()) {
			cout << scenMap[scen[i]] << ' ';
		}
		else {
			cout << -1 << ' ';
		}
	}

	return 0;
}
