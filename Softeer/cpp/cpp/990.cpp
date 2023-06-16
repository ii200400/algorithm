// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=990
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214036&psProblemId=990
// 소프티어 근무시간

// cpp 언어 테스트

/*
2번째 레벨1 문제
*/

#include <iostream>
#include <string>
using namespace std;

int main() {
	// 근무 시작 시간, 종료 시간
	string s, e;
	int workTime = 0;
	for (int i = 0; i < 5; i++) {
		cin >> s >> e;
		// cout << s << ' ' << e << endl;

		int startH = stoi(s.substr(0, 2));
		int startM = stoi(s.substr(3, 5));
		// cout << startH << ' ' << startM << endl;

		int endH = stoi(e.substr(0, 2));
		int endM = stoi(e.substr(3, 5));
		// cout << endH << ' ' << endM << endl;

		workTime += 60 * (endH - startH) + (endM - startM);
		// cout << workTime << endl;
	}
	
	cout << workTime << endl;

	return 0;
}