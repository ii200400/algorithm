// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=623
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214605&psProblemId=623
// 소프티어 비밀 메뉴

// 쉬어갈겸 푸는 level 2문제

/*
다섯번째 레벨 2 문제

분명히.. 읽은 문제같은데.. 답안제출은 없고.. 
그냥풀자!

본래는 문자열 매칭 알고리즘이 생각났으나.. 
제약조건을 보니 해당 알고리즘을 활용하지 않아도 될 것 같고
무엇보다 문자열 매칭 알고리즘을 구현하기에 이해가 덜 되어 시간이 걸릴 것 같아
완전탐색으로 진행하였다.
*/

#include <iostream>
using namespace std;

int main() {
	// 버튼 수, 조작법 길이, 버튼 조작 길이
	int k, m, n;
	cin >> m >> n >> k;

	// 비밀메뉴 조작법, 버튼 입력
	int* secret = new int[m];
	int* click = new int[n];

	for (int i = 0; i < m; i++) {
		cin >> secret[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> click[i];
	}

	// n<m인 경우를 고려하여 false로 초기화
	bool isSecret = false;
	for (int i = 0; i <= n - m; i++) {
		isSecret = true;

		// 비밀메뉴 조작법이 있는지 확인해서
		for (int j = 0; j < m; j++) {
			if (secret[j] != click[i + j]) {
				isSecret = false;
				break;
			}
		}

		// 조작법이 있다면 탈출
		if (isSecret) {
			break;
		}
	}

	// 조작법 포함 여부에 맞게 출력
	if (isSecret) {
		cout << "secret" << endl;
	}
	else {
		cout << "normal" << endl;
	}

	delete secret, click;

	return 0;
}