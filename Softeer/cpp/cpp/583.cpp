// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=583
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_143459&psProblemId=583
// 소프티어 GINI야 도와줘

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
W(세차장)에서 H(집)까지 *(소나기)와 X(강)을 피해서 최소한의 시간으로 갈 수 있는 프로그램..을 만들면 된다.
저번 문제에서 DFS를 사용했더니 이번에는 BFS를 사용하는 문제가 나와서 좋다.

아.. cpp에서는 자바와는 다르게 동적할당을 사용해야 원하는 결과가 나온다;;
블록을 벗어나도 해당 변수가 기억되고있다가 다시 그 블록에 들어가면 이전에 사용한 변수를 그대로 사용하는 것 같다.
왜 생각한 값이 안나오나 했더니 해당 블록에 들어갈 때마다 블록의 변수 값을 덮어씌워버리기 때문;

으윽; 게다가 코드 복붙하다가 빠뜨린 부분도 있어서 로직은 맞는데 내 머리속 로직만 맞아서 통과가 안되고 있었다.
*/

#include <iostream>
#include <queue>

using namespace std;

int main() {
	// 맵의 세로, 가로
	int r, c;
	cin >> r >> c;

	// 소나기 큐와 차로 갈 수 있는 위치 큐
	queue<int*> rains, car;
	// 맵 배열
	char** map = new char* [r];

	// 맵과 큐들 초기화
	for (int i = 0; i < r; i++) {
		map[i] = new char[c];
		for (int j = 0; j < c; j++) {
			cin >> map[i][j];

			if (map[i][j] == 'W')
			{
				int* temp = new int[2] { i, j };
				car.push(temp);
			}
			else if (map[i][j] == '*') {
				int* temp = new int[2] { i, j };
				rains.push(temp);
			}
		}
	}

	// 4방향 
	int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
	// 자동차 큐의 크기, 이동 회수
	int size, cnt = 0;
	// 자동차 위치 가로/세로, 자동차 움직일 위치 가로/세로
	int currentR, currentC, dr, dc;

	// 자동차가 못 움직일 때까지 반복
	while (car.size() > 0) {
		cnt++;
		// 소나기가 움직인다.
		size = rains.size();
		for (int i = 0; i < size; i++) {
			currentR = rains.front()[0], currentC = rains.front()[1];
			rains.pop();

			// 4방향으로 퍼져나가는데
			for (int j = 0; j < 4; j++) {
				dr = currentR + dir[j][0];
				dc = currentC + dir[j][1];

				// 맵 밖을 벗어나면 패스
				if (dr < 0 || r <= dr)
					continue;
				if (dc < 0 || c <= dc)
					continue;

				// .인 곳만 퍼져나가도록 한다.
				if (map[dr][dc] == '.'){
					int* temp = new int[2] {dr, dc};
					rains.push(temp);
					// 소나기 표시를 맵에 남겨본다.
					map[dr][dc] = '*';
				}
			}
		}

		// 차가 움직인다.
		size = car.size();
		for (int i = 0; i < size; i++) {
			currentR = car.front()[0], currentC = car.front()[1];
			car.pop();

			// 4방향으로 갈 수 있는데
			for (int j = 0; j < 4; j++)
			{
				// 움직이는 위치가
				dr = currentR + dir[j][0];
				dc = currentC + dir[j][1];

				// 맵 밖을 벗어나면 패스
				if (dr < 0 || r <= dr)
					continue;
				if (dc < 0 || c <= dc)
					continue;

				// 집이면 정답출력
				if (map[dr][dc] == 'H') {
					cout << cnt << endl;
					return 0;
				}

				// .일 때만 이동 
				if (map[dr][dc] == '.') {
					int* temp = new int[2] {dr, dc};
					car.push(temp);
					// 차가 지나왔다는 표시를 맵에 남겨본다.
					map[dr][dc] = 'W'; 
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				cout << map[i][j] << ' ';
			}
			cout << endl;
		}
	}

	// 차가 집에 도착하지 못하면 FAIL 출력
	cout << "FAIL" << endl;

	return 0;
}