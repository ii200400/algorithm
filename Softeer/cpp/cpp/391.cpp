// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=391
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_140385&psProblemId=391
// 소프티어 수퍼바이러스

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
버스타면서 생각한 결과 시간을 2진법을 활용해서 풀면 조금 빠를 것 같다는 결론이 나왔다.
예를 들어서 입력이
1 2 5 
라고 하면

5를 2진법으로 하면 101이 되니 
초기 값에 2^10을 곱하고
(2^10)^2는 안 곱하고
(2^10)^2^2는 곱해주는 방식으로 하는 것이다.
물론 중간중간 1000000007로 나눠주어야 한다.

그러면 n이 10^16이어도 나쁘지 않은 속도로 해결할 수 있을 것 같다. 
안되면.. 다시 고민해야겠다.

야호~ 통과하였다~
*/

#include <iostream>
using namespace std;

int main() {
	// 초기 바이러스 수, 증가율(0.1초), 증가율(초), 총 시간(초)
	long long k, p, sp, n;
	cin >> k >> p >> n;

	// 1초마다 증가하는 바이러스 수를 계산한다.
	sp = p;
	for (int i = 0; i < 9; i++) {
		sp = sp * p % 1000000007;
	}

	// n을 2로 나누면서 나머지가 나올 때 마다 증가율을 곱해준다.
	while (n > 0)
	{
		if (n % 2 == 1)
		{
			k = k * sp % 1000000007;
		}
		
		// n을 2로 나눈다.
		n /= 2;

		// 현재 수를 제곱한다.
		sp = sp * sp % 1000000007;
	}

	cout << k << endl;

	return 0;
}