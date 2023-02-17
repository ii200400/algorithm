// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=580
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_147997&psProblemId=580
// 소프티어 안전운전을 도와줄 차세대 지능형 교통시스템

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
쓰읍.. 백준에서 이름은 모르겠는데 cctv를 주제로한 비슷한 문제가 기억난다.
상황에 적절하게 시뮬레이션 코딩인데.. 수식을 활용할 예정이고.. 이거는 3번 참조할지도 모르겠다;;

이해는 쉬운데.. 복잡하기는 말로 다 하기 힘들정도일 것이다.
게다가, 설마 시간초과 문제가 생기는지 잘 모르겠다.
시뮬레이션 문제라면 보통은! 시간초과를 덜 고려하는 문제가 일반적이므로 생략하고 진행하겠다!

.. 라고 했는데 진행하면서 방문처리해서 결과를 출력하는 것 때문에 자연스럽게 적용하게 되었다.
처음 생각했던 것과는 다르게 시간관리해주는 방법도 간략화 할 수 있는 방법을 생각해서 크게 어렵게 구현하지는 않았다.


아니?? 이게 바로 통과되네? 야호!
중간에 주석 작성하면서 turn 배열을 사용해야하는 부분이 있었는데 빼먹었던 곳을 빼면 문제는 없었나보다.
음.. 나중에 이거.. 내가 알아볼 수 있을지 모르겠다;; 
이런문제 항상 이런식으로 풀어서 이해는 하겠는데 즐겁지 않을 것 같다;
*/

#include <iostream>
#include <queue>
using namespace std;

// 동북서남 별 이동 방식 (교차로의 신호 1,2,3,4의 진입 방향과 동일해야만 함)
int dir[4][2] = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };
// 좌회전, 직진, 우회전 별 방향 전환
int turn[3] = { 1, 0, 3 };
// 신호 1, 5, 9 정보 (좌회전, 직진, 우회전이 가능한지 여부, 신호 1,2,3,4는 정보가 같으므로 신호 1,5,9 만 입력)
bool sign[3][3] = { {true, true, true}, {true, true, false}, {false, true, true} };

int main() {
	// 교차로 크기, 주어진 시간
	int n, t;
	cin >> n >> t;

	// 교차로 방문 여부 (행,열, 시간별 방문여부 - 마지막은 시간 무관하게 방문은 한 경우를 위해)
	bool*** visited = new bool** [n];
	// 교차로 신호 집합
	int*** crossSign = new int** [n];
	for (int i = 0; i < n; i++)
	{
		crossSign[i] = new int* [n];
		visited[i] = new bool* [n];
		for (int j = 0; j < n; j++)
		{
			crossSign[i][j] = new int [4];
			visited[i][j] = new bool[5] {false, false, false, false, false};
			for (int k = 0; k < 4; k++)
			{
				int temp;
				cin >> temp;
				crossSign[i][j][k] = temp - 1;
			}
		}
	}
	
	// {현재 교차로의 행, 현재 교차로의 열, 차의 방향}
	// 차는 처음에 북쪽을 바라보며 제일 왼쪽 위의 교차로에 있다.
	queue<int*> q;
	q.push(new int[3] {0, 0, 1});

	// 지난 시간
	int time = 0; 

	// 운행 시작
	while (time <= t) {
		int qSize = q.size();

		for (int i = 0; i < qSize; i++) {
			// 차의 현재 위치와 방향
			int x = q.front()[0], y = q.front()[1], carDir = q.front()[2];
			q.pop();

			visited[x][y][4] = true;

			// 해당 교차로의 현재 신호와 맞지않는 신호라면 생략
			if (crossSign[x][y][time % 4] % 4 != carDir) continue;

			// 해당 교차로의 해당 신호를 받았었다면 생략 (방문처리)
			if (visited[x][y][time % 4]) continue;
			visited[x][y][time % 4] = true;

			// 신호를 받아서 자동차를 움직인다.
			bool* s = sign[crossSign[x][y][time % 4] / 4];
			for (int i = 0; i < 3; i++)
			{
				// (좌회전/직진/우회전)을 할 수 없다면 생략
				if (s[i] == false) continue;

				// 방향에 따른 현 위치를 갱신해주고 정보를 큐에 넣어준다.
				int tempDir = (carDir + turn[i]) % 4;
				int dx = x + dir[tempDir][0], dy = y + dir[tempDir][1];

				// 범위 밖으로 나가는 경우도 생략
				if (dx < 0 || n <= dx || dy < 0 || n <= dy) continue;

				q.push(new int[3] {dx, dy, tempDir});
			}
		}

		time++;
	}

	// 방문한 교차로 수
	int cnt = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (visited[i][j][4]) {
				// 디버깅용
				//cout << i << ' ' << j << endl;
				cnt++;
			}
		}
	}

	cout << cnt << endl;

	return 0;
}