// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=626
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_214539&psProblemId=626#hold
// 소프티어 회의실 예약

// 쉬어갈겸 푸는 level 2문제

/*
네번째 레벨 2 문제

와! 고전 문제! 회의실!
내가 생각하는 그 회의실문제인지 궁금하다.

아니다, 정렬해서 겹치는지 확인하는 그 문제가 아니라 그냥 열심히 출력하는 문제이다.
printf 출력방식 까먹었을 줄 알았는데 바로 생각나서 의외로 놀랐다!

생각나는 방법이 별로 없어 아-주 원시적인 방법으로 해결하려고 한다.
map에 방의 정보를 넣고 예약가능한 시간대를 배열로 저장해두는 방식이다.

출력 방식에 맞춰서 하다보니 조금 복잡한 코드가 나오고 말았다;
*/

#include <iostream>
#include <map>
using namespace std;

int main() {
	// 방의 수, 회의 수
	int n, m;
	cin >> n >> m;

	// 방의 정보를 저장하는 map 변수
	map<string, bool*> rooms = map<string, bool*>();
	// 방 이름
	string roomName;
	for (int i = 0; i < n; i++) {
		cin >> roomName;

		// 방의 회의시간 초기화
		rooms[roomName] = new bool[10] {false, };
		rooms[roomName][9] = true;
	}

	// 회의 시작 / 종료 시간
	int start, end;
	for (int i = 0; i < m; i++) {
		cin >> roomName >> start >> end;

		for (int j = start; j < end; j++) {
			rooms[roomName][j-9] = true;
		}
	}

	/*
	for (auto roomInfo : rooms) {
		cout << roomInfo.first << ' ';
		for (int i = 0; i < 10; i++) {
			cout << roomInfo.second[i] << ' ';
		}
		cout << endl;
	}
	*/
	
	// ----- 를 하나 덜 출력하게 만들기 위해서 만든 변수..
	int size = rooms.size();
	int cnt = 0;
	// 남은 시간에 맞춰 회의실 별 남은 시간을 출력한다.
	for (auto roomInfo : rooms) {
		cnt++;
		cout << "Room " << roomInfo.first << ":" << endl;

		// 시간을 살펴보면서 이전 시간은 사용되었는지 여부
		bool pre = true;

		// 가능한 시간대가 몇개 있는지부터 출력
		int timeCnt = 0;
		for (int i = 0; i < 10; i++) {
			if (pre == roomInfo.second[i]) continue;

			if (pre) { // 사용을 끝낸(treu에서 false가 된) 것이라면
				pre = false;
				timeCnt++;
			}
			else { // 사용하기 시작한(false에서 true가 된) 것이라면
				pre = true;
			}
		}

		// 예약 가능한 시간대 수
		if (timeCnt == 0) {
			cout << "Not available" << endl;
		}
		else {
			cout << timeCnt << " available:" << endl;
		}

		pre = true;
		for (int i = 0; i < 10; i++) {
			// 계속 사용하거나 사용을 안하고 있다면 출력하지 않는다.
			if (pre == roomInfo.second[i]) continue;

			if (pre) { // 사용을 끝낸(treu에서 false가 된) 것이라면
				printf("%02d-", i + 9);
				pre = false;
			}
			else { // 사용하기 시작한(false에서 true가 된) 것이라면
				printf("%02d\n", i + 9);
				pre = true;
			}
		}

		if (cnt == size) break;
		cout << "-----" << endl;
	}
	
	return 0;
}