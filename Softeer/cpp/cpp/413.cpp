// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=413
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214726&psProblemId=413
// 소프티어 지도 자동 구축

// 쉬어갈겸 푸는 level 2문제

/*
여섯번째 레벨 2 문제

어.. 레벨2가 맞나..? 내가 수리적인 문제는 잘 파악해서 난이도가 낮게 느껴지는 건가..?
이유가 있겠지~
*/

#include <iostream>
using namespace std;

int main() {
	// 단계 입력
	int n;
	cin >> n;

	// 한 선에 존재하는 점의 수
	int dotWidth = 3;
	for (int i = 1; i < n; i++) {
		dotWidth = dotWidth * 2 - 1;
	}

	cout << dotWidth * dotWidth << endl;

	return 0;
}