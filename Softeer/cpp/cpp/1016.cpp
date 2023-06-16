// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=1016
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214038&psProblemId=1016
// 소프티어 주행거리 비교하기

// cpp 언어 테스트

/*
레벨1은 이정도로 쉬워야하는구나 싶었다.
*/

#include <iostream>
using namespace std;

int main() {
	int a, b;
	cin >> a >> b;

	if (a == b) {
		cout << "same";
	}
	else if (a > b) {
		cout << "A";
	}
	else {
		cout << "B";
	}

	return 0;
}