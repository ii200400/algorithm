// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=584
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214079&psProblemId=584
// 소프티어 GBC

// 쉬어갈겸 푸는 level 2문제

/*
두번째 레벨 2 문제

문제 설명이 더 어려운 기분이 든다..

이해하니 그냥 간단한.. 조건문제였다.
구간별로 속도의 차가 가장 큰 부분을 찾아서 출력하도록 만들어주었다.
*/

#include <iostream>
using namespace std;

int main() {
	// 제한속도 구간 수, 속도 검사 구간 수
	int n, m;
	cin >> n  >> m;

	// 제한속도와 속도검사 구간 초기화
	pair<int, int>* limits = new pair<int, int>[n];
	pair<int, int>* speeds = new pair<int, int>[m];

	for (int i = 0; i < n; i++) {
		cin >> limits[i].first >> limits[i].second;
	}
	for (int i = 0; i < m; i++) {
		cin >> speeds[i].first >> speeds[i].second;
	}

	// 구간마다 제한속도와 속도검사 차이 계산

	// 정답
	int answer = 0;
	// 현재 참고중인 한계속도와 속도검사 인덱스
	int limiteIdx = -1, speedIdx = -1;
	// 한계속도와 속도검사 범위 (둘을 비교해서 다음 구간을 더하거나 한다.)
	int limiteLen = 0, speedLen = 0;
	do {
		// 두 구간의 이전 범위에 따라서 다음 범위를 더해준다.
		if (limiteLen == speedLen) {
			limiteIdx++;
			speedIdx++;
			limiteLen += limits[limiteIdx].first;
			speedLen += speeds[speedIdx].first;
		}
		else if (limiteLen > speedLen) {
			speedIdx++;
			speedLen += speeds[speedIdx].first;
		}
		else {
			limiteIdx++;
			limiteLen += limits[limiteIdx].first;
		}

		// cout << "len : " << limiteLen << ' ' << speedLen << endl;
		// cout << "speed: " << limits[limiteIdx].second << ' ' << speeds[speedIdx].second << endl;

		// 현재 범위의 속도 차를 구하고 그 값이 크면 저장한다.
		int diff = speeds[speedIdx].second - limits[limiteIdx].second;
		if (diff > answer) {
			answer = diff;
		}

		// 위의 방법을 모든 구간(100m)를 탐색할 때까지 반복한다.
	} while (limiteLen != 100 || speedLen != 100);

	cout << answer << endl;

	delete limits, speeds;

	return 0;
}