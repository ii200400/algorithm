// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=633
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_147080&psProblemId=633
// 소프티어 비밀 메뉴2

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
음..? 그냥.. 구현문제인건가?
인덱스를 잘 조작하면서 카운팅하기만 하면 될 것 같다. 시간초과도 생기지 않을 것 같은데..
이게.. 본선문제?

어욱.. 변수 햇갈린다;; 위의 방법 그대로 적용해서 해결하였다.
*/

#include <iostream>
using namespace std;

int main() {
	// 버튼 수열1, 버튼 수열2, 수의 범위
	int n, m, k;
	cin >> n >> m >> k;

	// 수열들 생성 및 초기화
	int* button1 = new int[n];
	int* button2 = new int[m];

	for (int i = 0; i < n; i++) {
		cin >> button1[i];
	}
	for (int i = 0; i < m; i++) {
		cin >> button2[i];
	}

	// 항상 수열 1이 수열2보다 짧은 것이 들어가도록 한다.
	int size1 = n, size2 = m;
	if (n > m) {
		int* temp = button1;
		button1 = button2;
		button2 = temp;

		size1 = m, size2 = n;
	}

	int cnt = 0, max = 0;
	// 순서대로 살펴본다.
	// 수열 1이 2 2 3 4 5, 수열 2가 1 1 6 7 8 이라면
	// 2 2 3 4 5
	//         1 1 6 7 8 과 같은 방식으로 비교
	for (int i = size1 - 1; i > 0; i--) {
		for (int j = 0; j < size1 - i; j++) {
			//cout << button1[i + j] << ' ' << button2[j] << endl;
			if (button1[i + j] == button2[j]) cnt++;
			else {
				if (max < cnt) max = cnt;
				cnt = 0;
			}
		}

		if (max < cnt) max = cnt;
		cnt = 0;
	}

	// 수열 1이 2 2 3 4 5, 수열 2가 1 1 6 7 8 9 1 이라면
	//   2 2 3 4 5
	// 1 1 6 7 8 9 1과 같은 방식으로 비교
	for (int i = 0; i <= size2 - size1; i++) {
		for (int j = 0; j < size1; j++) {
			//cout << button1[j] << ' ' << button2[i + j] << endl;
			if (button1[j] == button2[i+j]) cnt++;
			else {
				if (max < cnt) max = cnt;
				cnt = 0;
			}
		}

		if (max < cnt) max = cnt;
		cnt = 0;
	}

	// 수열 1이 2 2 3 4 5, 수열 2가 1 1 6 7 8 9 1 이라면
	//         2 2 3 4 5
	// 1 1 6 7 8 9 1과 같은 방식으로 비교
	for (int i = 1; i < size1; i++) {
		for (int j = 0; j < size1 - i; j++) {
			//cout << button1[j] << ' ' << button2[size2 - (size1 - i) + j] << endl;
			if (button1[j] == button2[size2 - (size1 - i) + j]) cnt++;
			else {
				if (max < cnt) max = cnt;
				cnt = 0;
			}
		}

		if (max < cnt) max = cnt;
		cnt = 0;
	}

	// 가장 긴 부분수열 길이 출력
	cout << max << endl;

	return 0;
}