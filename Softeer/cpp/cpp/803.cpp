// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=803
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_146923&psProblemId=803
// 소프티어 교차로

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
음.. 시뮬레이션 문제이다. 주어진대로 동작하는 코드만 작성하면 될 것 같다.
시뮬레이션 문제는 오랫만이라서 변수를 잘못 작성하지 않기만하면 좋을 것 같다.

입력받은 차량을 순서대로 넣을 때, 크기를 넘어가는 경우의 예외처리와
교차로에서 차량이 지나갈 예정인 것을 바로 큐에서 빼버려서 가면 안되는 차량까지 가버리게 만든 것을 제외하면
문제없이 잘 구현하였다.
*/

#include <iostream>
#include <queue>
using namespace std;

int main() {
	// 자동차 수
	int n;
	cin >> n;

	// 각 위치의 차량 번호 0:A 1:B 2:C 3:D
	queue<int*> load[4];
	// 각 차량의 진입 시간
	int** cars = new int*[n];
	// 각 차량이 교차로를 통과한 시간
	int* passTime = new int[n];
	for (int i = 0; i < n; i++)
	{
		passTime[i] = -1;
	}

	// 방향, 진입시간
	int inTime;
	char dir; // A:65
	for (int i = 0; i < n; i++)
	{
		cin >> inTime >> dir;
		cars[i] = new int[3] { inTime , dir - 65, i };
		//cout << cars[i][0] << ' ' << cars[i][1] << endl;
	}

	// 시간, 입력으로 받아온 자동차를 탐색하기 위한 인덱스
	int time = 0, idx = 0;
	while (true) {
		for (;idx < n && time == cars[idx][0]; idx++) {
			load[cars[idx][1]].push(cars[idx]);
		}

		// 교차로에서 갈 수 있는 자동차를 탐색한다.
		int isPass = 0; // 차가 교차로를 지나갔는지 저장 (비트마스킹)
		for (int i = 0; i < 4; i++)
		{
			// 한 방향에 자동차가 있고 그 차선의 오른쪽에 자동차가 없다면 자동차 직진 
			if (load[i].size() > 0 && load[(i + 3) % 4].size() == 0) {
				passTime[load[i].front()[2]] = time;
				isPass |= 1 << i;
			}
		}

		// 직진한 자동차는 큐에서 제거시켜준다.
		for (int i = 0; i < 4; i++) {
			if (isPass & 1 << i) {
				load[i].pop();
			}
		}

		// 어떤 차도 움직이지 못했는데
		if (isPass == 0) {
			// 차량이 정체되었거나 더 이상 진입할 차량이 없다면 반복문 탈출
			if (load[0].size() > 0 || idx >= n)
			{
				break;
			}
			// 그렇지 않으면(그냥 교차로에 차가 없는 경우) 시간을 조정(차가 진입하는 시간까지 빨리감기)해준다.
			else{
				time = cars[idx][0];
				continue;
			}
		}

		// 시간이 흐른다.
		time++;
	}

	// 자동차가 교차로를 지나는 시간 출력
	for (int i = 0; i < n; i++)
	{
		cout << passTime[i] << endl;
	}

	return 0;
}