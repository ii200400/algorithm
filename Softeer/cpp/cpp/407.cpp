// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=407
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214045&psProblemId=407
// 소프티어 바이러스

// 쉬어갈겸 푸는 level 2문제

/*
쉬어갈겸 푼다고 썼지만 사실 level 3 문제를.. (몰라서 못 풀겠는거 제외하고) 하나 빼고 다 풀었다.
어차피 내일 코딩테스트니 가볍게 레벨2 문제를 최대한 풀어보려고 한다!
현재 소프티어에 있는 레벨 2 문제는 9개이니 운이 좋으면 다 풀수 있을 것 같다.

문제를 읽으니 long 형을 쓰지 않으면 오버플로우로 고통받는 문제같다.
이 외에는 특별한 것이 보이지 않는다.
*/

#include <iostream>
using namespace std;

int main() {
	// 바이러스 수, 증가율, 시간
	int k, p, n;
	cin >> k >> p >> n;

	// int 형을 쓰면 오버플로우가 일어날 숫자 제한이므로 long long
	long long cnt = k;
	for (int i = 0; i < n; i++) {
		// 계산할 때마다 나눠준다.
		cnt = (cnt * p) % 1000000007;
	}

	// 바이러스 수를 1000000007로 나눈 값
	cout << cnt << endl;

	return 0;
}