// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=624
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214214&psProblemId=624
// 소프티어 전광판

// 쉬어갈겸 푸는 level 2문제

/*
세번째 레벨 2 문제

오.. 본 적이 없는 문제이다. 흥미가 생긴다.
나누기와 나머지를 활용해서 수가 남아있는지 확인하고 
각 숫자별 스위치가 켜져있는지 아닌지 확인하면서 스위치의 최소 조작회수를 세면 될 것 같다.

-- 1차 시도 --
오답이 생겼는데 왜 생긴지 모르겠다;; 
어우.. 숫자9의 0과 1이 하나 바뀌어있었다;; 사람살려..
*/

#include <iostream>
using namespace std;

// 전광판의 불의 스위치 상태(순서대로 상단 위, 왼쪽, 오른쪽, 중간, 하단 왼쪽, 오른쪽, 아래 부분)
bool lights[11][7] = { 
	{1, 1, 1, 0, 1, 1, 1}, // 0
	{0, 0, 1, 0, 0, 1, 0}, // 1
	{1, 0, 1, 1, 1, 0, 1}, // 2
	{1, 0, 1, 1, 0, 1, 1}, // 3
	{0, 1, 1, 1, 0, 1, 0}, // 4
	{1, 1, 0, 1, 0, 1, 1}, // 5
	{1, 1, 0, 1, 1, 1, 1}, // 6
	{1, 1, 1, 0, 0, 1, 0}, // 7
	{1, 1, 1, 1, 1, 1, 1}, // 8
	{1, 1, 1, 1, 0, 1, 1}, // 9 
	{0, 0, 0, 0, 0, 0, 0} // 숫자 없음
};

int main() {
	// 테스트 케이스 수
	int t;
	cin >> t;

	for (int i = 0; i < t; i++) {
		// 입력받은 두 숫자
		int a, b;
		cin >> a >> b;

		// 스위치 조작 회수
		int cnt = 0;

		// 각 숫자의 자리수를 비교하면서 스위치 조작 회수를 센다.
		while (a != 0 || b != 0) {
			// 숫자를 하나씩 비교한다.
			int numA = a % 10;
			int numB = b % 10;
			a /= 10;
			b /= 10;
			
			if (numA == 0 && a == 0) { // A 숫자의 자리수가 부족한 경우
				for (int j = 0; j < 7; j++) {
					if (lights[10][j] != lights[numB][j]) cnt++;
				}
			}
			else if (numB == 0 && b == 0) { // B 숫자의 자리수가 부족한 경우
				for (int j = 0; j < 7; j++) {
					if (lights[numA][j] != lights[10][j]) cnt++;
				}
			}
			else { // 그 외의 경우
				for (int j = 0; j < 7; j++) {
					if (lights[numA][j] != lights[numB][j]) cnt++;
				}
			}
		}

		// 스위치 최소 조작 회수 출력
		cout << cnt << endl;
	}

	return 0;
}