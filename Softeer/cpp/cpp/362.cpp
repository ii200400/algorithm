// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=362
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=362&submissionSn=SW_PRBL_SBMS_213953
// 소프티어 A+B

// cpp 언어 테스트

/*
요즘 너무 어려운 문제만 풀어서 기부니를 위해서 쉬운문제 조금 풀려고 한다!

그런데 너무 쉽다; 레벨이 2는 되어야하는 것 같다.
그래도 일단 레벨1 문제는 3개뿐이니 다 풀어보려고 한다.
*/

#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int temp1, temp2;
		cin >> temp1 >> temp2;

		cout << "Case #" << i + 1 << ": " << temp1 + temp2 << endl;
	}

	return 0;
}