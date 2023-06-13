// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=540
// 제출 링크 : 
// 소프티어 Garage game

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
어휴.. 완전탐색에 dfs/bfs에 사각형 계산에 칸 옮기기가 가미된 시뮬레이션이라니..
아카데미에서도 사각형 확인과 칸 추가가 없는 비슷한 문제가 있었는데 풀 줄 아는 사람이 거의 없었던 기억이 있다.
이런 문제 나오면 3시간도 더 구현하다가 틀리는 경우가 많은데 본인도 마찬가지이다.
내일이 코테이므로 생략하고 진행하겠다.

---대략 4달 후---

도전해보려고 한다. 당장 생각나는 방법은 메모리를 많이 소모하는.. 완전탐색 방법이다.
3차례만 진행되므로 시간초과는 생기지 않을 것이라고 생각했기 때문이다.

방법은 아래와 같다.
1. 선택 여부와 차고 정보를 저장하는 배열을 만들고 초기화 한다.
선택 여부라는 것은 완전탐색으로 해당 차례를 진행하면서 자동차가 사라진 여부를 말한다.
2. 왼쪽 위부터 오른쪽 아래까지 순차적으로 선택한 적이 없다면 선택한다.
3. 배열을 새로 만들어 이전 배열을 복사하고 사라진 자동차와 위의 자동차에 따라 업데이트(점수나 차고정보) 시킨다.
3-1. 이 때 최고점수라면 저장해주고 3번째 진행한다면 return 한다.
4. 새로운 배열을 다시 2번부터 새로 진행한다. 

얼마나 버그를 만들지 벌써부터 기대된다 ^ㅠ^ b

nr에 n 쓰고 특수한 범위인 것 까먹어서 2*n대신 0 쓰고 변수를 중복으로 작성하고 
방문시 처리해주어야 할 것 빠뜨리고 아주 난리났다.

---1차 시도---
메모리 초과로 인한 컴파일에러가 생겼다. 
꼬박꼬박 delete를 사용했는데.. 이것과는 무관하게 생기는 것인가..?

생각해보니 시뮬레이션은 3번 일어나고 원본까지 합치면 4개의 2차원 배열만으로 해결할 수 있다는 것을 알았다.
당장해야지!

---2차시도---
어.. 메모리는 확실하게 줄일 수 있었다. 250mb에 달했던 것을 최대 32mb까지로 줄였다.
대신 시간초과가 생겼다.

생각해보니 방문배열도 같은 방식으로 줄일수 있네..

아니 뭐 시간초과가 계속나는데, 어떻게 줄이라는 것인지 알 수가 없다. 
그래서 10퍼 이하의 정답률을 보이는듯;

*/

#include <iostream>
#include <queue>
using namespace std;

// 최고점수
int maxScore = 0;
// 차고 크기
int n;
// 차고 정보
int** carage[4];
// 방문 정보
bool** visited[4];

// 직사각형의 넓이를 구할 때 사용하는 변수들
int top, bot, lef, rit;
// 자동차 색상 번호, 사라질 자동차 수
int carNum, num;

int dr[4] = { 0, 0, 1, -1 };
int dc[4] = { 1, -1, 0, 0 };

// 주변의 같은 자동차를 확인하고 선택한다면 얻게 될 점수를 반환한다.
// 차고 배열, 방문 여부, 가로, 세로
void dfs(int r, int c, int time) {
	// 주변 자동차를 살펴보는데
	for (int i = 0; i < 4; i++) {
		int nr = r + dr[i], nc = c + dc[i];

		// 차고 범위를 벗어난다면 생략한다.
		if (nr < 2 * n || nr >= 3 * n || nc < 0 || nc >= n) continue;
		// 차량 색상이 달라도 생략, 방문 경험이 있어도 생략
		if (carage[time][nr][nc] != carNum || visited[time-1][nr - 2 * n][nc]) continue;

		// 방문처리
		visited[time-1][nr - 2 * n][nc] = true;
		carage[time][nr][nc] = 0;
		num++;

		
		// 디버깅용
		// cout << rit << " " << lef << ' ' << top << ' ' << bot << ' ' << num << endl;
		// cout << nr << " " << nc << endl;

		// 직사각형 계산
		if (top > nr) top = nr;
		else if (bot < nr) bot = nr;
		if (lef > nc) lef = nc;
		else if (rit < nc) rit = nc;

		// 계속 살펴보기
		dfs(nr, nc, time);
	}
}

// 자동차를 선택하고 점수를 버는 게임 진행
// 차고 배열, 점수, 시뮬레이션 회수
void game(int score, int time) {

	// 방문배열 초기화
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			visited[time-1][i][j] = false;
		}
	}

	// 자동차를 선택해본다.
	for (int i = 2 * n; i < 3 * n; i++) {
		for (int j = 0; j < n; j++) {
			// 이미 선택한적이 있는 자동차라면 생략
			if (visited[time-1][i-2*n][j] || carage[time-1][i][j] == 0) continue;

			// 새 배열 초기화
			for (int k = 0; k < 3 * n; k++) {
				for (int l = 0; l < n; l++) {
					carage[time][k][l] = carage[time - 1][k][l];
				}
			}

			// 방문처리
			visited[time-1][i - 2 * n][j] = true;
			carage[time][i][j] = 0;

			lef = j, rit = j, top = i, bot = i;
			carNum = carage[time-1][i][j], num = 1;

			dfs(i, j, time);

			// 점수 계산하기
			int tempScore = score + (rit - lef + 1) * (bot - top + 1) + num;

			// 디버깅용
			// cout << rit << " " << lef << ' ' << top << ' ' << bot << ' ' << num << endl;
			// cout << "time : " << time << ", score : " << tempScore << endl;

			// 시뮬레이션을 모두 마쳤다면 최고점수인지 확인한다.
			if (time == 3) {
				if (maxScore < tempScore) maxScore = tempScore;
				continue;
			}

			// 사라진 자동차 공간을 채운다.
			for (int k = lef; k <= rit; k++) {
				queue<int> q;

				// 자동차를 발견하면 큐에 넣었다가
				for (int m = 3 * n - 1; m >= 0; m--) {
					if (carage[time][m][k] != 0) {
						q.push(carage[time][m][k]);
						carage[time][m][k] = 0;
					}
				}
				
				// 차례대로 쌓아준다.
				for (int m = 3 * n - 1; !q.empty(); m--) {
					int temp = q.front();
					q.pop();
					carage[time][m][k] = temp;
				}
			}

			// 디버깅용 (차고 출력)
			/*
			for (int k = 0; k < 3 * n; k++) {
				for (int l = 0; l < n; l++) {
					cout << newCarage[k][l] << ' ';
				}
				cout << endl;
			}
			*/
			
			game(tempScore, time + 1);

		}
	}
}

int main() {
	cin >> n;
	// 차고 배열 생성(동적할당)
	for (int i = 0; i < 4; i++) {
		carage[i] = new int* [3 * n];
		for (int j = 0; j < 3 * n; j++) {
			carage[i][j] = new int[n];
		}
	}

	// 차고 첫번째 배열 초기화
	for (int j = 0; j < 3 * n; j++) {
		for (int k = 0; k < n; k++) {
			cin >> carage[0][j][k];
		}
	}

	// 방문 배열 생성 및 초기화
	for (int i = 0; i < 4; i++) {
		visited[i] = new bool* [n];
		for (int j = 0; j < n; j++) {
			visited[i][j] = new bool[n];
		}
	}

	// cout << "gamestart" << endl;
	// 게임 시작
	game(0, 1);

	cout << maxScore << endl;

	// 차고, 방문 배열 삭제
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3 * n; j++) {
			delete carage[i][j];
		}
		delete carage[i];
	}

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < n; j++) {
			delete visited[i][j];
		}
		delete visited[i];
	}

	return 0;
}