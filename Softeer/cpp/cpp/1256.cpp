// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=1256
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=1256&submissionSn=SW_PRBL_SBMS_180323
// 소프티어 업무 처리

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
포화이진트리의 조직 구성도를 가진다.
조금 햇갈린 점이 있었는데 정황상, 작업을 처리하는 것은 하루씩 걸리고 
작업을 상사가 진행할 작업을 선택하는 것도 다음날 하는 것 같다.
1일에 서류 a와 b가 끝난다고 그날에 상사가 업무를 선택하는 것이 아니라 2일에 선택한다는 것.

어.. 수리적(비트마스킹)으로도 작성해서 말도안되게 빠르게 구현할 수도 있는 것 같긴한데.. 
너무 어렵게 생각하고 있는 것 같다.
합병정렬처럼 숫자를 합병해나가면서 말단직원의 업무가 부서장에게 가는 순서를 찾고 계산해야겠다.

예를 들어
h가 2이면
말단직원이 4명이고 왼쪽부터 0, 1, 2, 3 번째 직원이라고 할때
부서장에게 가는 말단직웝의 업무는 1, 3, 0, 2번 직원 순이다.
순서는 바뀌지 않으므로 순서를 먼저 찾고 순서대로 더해갈 예정이다.

어윽.. 배열을 수리적으로 지정하는 부분이 햇갈려서 오래걸렸다.
더 빠르게 진행하는 방법도 있겠지만 5ms도 빠르다고 생각한다. 통과했으니 넘어간다!

*/

#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int h, k, r;
	cin >> h >> k >> r;

	// 조직도의 높이보다 업무 진행 날짜가 더 적으면 부서장까지 업무가 갈 시간이 없다;
	if (r < h+1) {
		cout << 0 << endl;
		return 0;
	}

	// 말단직원의 업무가 부서장에게 가는 순서
	// 2,4,6,.. 이라면 2번째, 4번째, 6번째.. 말단직원의 업무가 부서장에게 순서대로 들어간다는 것
	// 직원의 숫자는 0부터 시작한다.
	int total = pow(2, h); // 총 말단 진원의 수
	int* order = new int[total];
	int* newOrder = new int[total];
	for (int i = 0; i < total; i++) {
		order[i] = i;
	}

	// 음.. 병합할 두 직원 그룹의 크기
	int size = 1;
	// 짝수날인지 아닌지 여부
	bool rit = true;

	// 업무순서 찾기
	while (size < total) {
		// 두 그룹을 병합
		for (int i = 0; i < total; i += size * 2) {
			for (int j = 0; j < size; j++) {
				if (rit) {
					newOrder[i + j * 2] = order[i + j + size];
					newOrder[i + j * 2 + 1] = order[i + j];
				}
				else {
					newOrder[i + j * 2] = order[i + j];
					newOrder[i + j * 2 + 1] = order[i + j + size];
				}
			}
		}

		// 병합한 그룹으로 배열을 교체
		int* temp = order;
		order = newOrder;
		newOrder = temp;

		// 디버깅용
		cout << "order : ";
		for (int j = 0; j < total; j++) {
			cout << order[j] << " ";
		}
		cout << endl;
		cout << rit << endl;

		// 다음 병합하는 크기는 2배에 반대편부터 진행
		size *= 2;
		rit = !rit;
	}

	// 조직도의 높이만큼 업무 작업 시간으로 지나게 된다.
	r -= h;
	// 완료된 업무의 번호 합
	int sum = 0;

	// 말단직원들이 받은 업무를 저장한다.
	int** works = new int*[total];
	for (int i = 0; i < total; i++) {
		works[i] = new int[k];
		for (int j = 0; j < k; j++) {
			cin >> works[i][j];
		}
	}

	// 진행하게 될 업무를 순서대로 더해간다.
	for (int i = 0; i < k ; i++) {
		for (int j = 0; j < total && r > 0; r--, j++) {
			sum += works[order[j]][i];
			//cout << works[order[j]][i] << " ";
		}
	}

	cout << sum << endl;

	// 동적변수들 해제
	delete order;
	delete newOrder;
	for (int i = 0; i < total; i++) {
		delete works[i];
	}
	delete works;

	return 0;
}