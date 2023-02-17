// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=577
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_146117&psProblemId=577
// 소프티어 로봇이 지나간 경로

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
완전탐색 밖에 생각나는 것이 없는데.. 진짜 완탐으로 가야하나..? 가로 세로 범위가 너무 큰다;

문제를 한 번 더 읽었더니!
로봇이 전진 명령에 2칸씩 이동하는 것과 같은 칸을 두번 방문하지 않는 조건으로 인해서
완탐이 아니라는 것을 알 수 있었다!

이유는 위의 조건으로 지나간 흔적인 #이 절대 겹치지 않고 어느 방향으로 진행했는지 파악하기 쉽기 때문!
#의 개수를 새면서 #인 칸이면서 주변에 #인 칸이 1개 밖에 없다면 그곳부터 탐색하도록 하면 된다.
쉽게 말하면, (선이 교차하지 않는) 한붓그리기의 시작점과 끝점을 확인해서 그곳을 시작점으로 삼으면 된다.
시작점으로 가능한 곳이 2곳이 나올텐데 음.. 무엇이든 정답처리를 해준다고 하니 문제는 없을 것 같다.

중간에 == 할 것을 = 으로 해서 해맷다;;
조건이 너무 많아서 1개 빼먹기도 했는데 금방 해결해서 풀 수 있었다.
그래도 한번에 통과해서 기부니는 좋다!
*/

#include <iostream>
using namespace std;

int main() {
	// 폭, 높이
	int w, h;
	cin >> h >> w;

	// 맵 초기화
	char** map = new char* [h+2];
	int hashCnt = 0;
	map[0] = new char[w + 2];
	map[h+1] = new char[w + 2];
	for (int i = 1; i <= h; i++)
	{
		map[i] = new char [w+2];
		for (int j = 1; j <= w; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == '#') hashCnt++;
		}
	}

	/*for (int i = 1; i <= h; i++)
	{
		for (int j = 1; j <= w; j++)
		{
			cout << map[i][j];
		}
		cout << endl;
	}*/


	// 시작 혹은 끝점 찾기
	int dir[4][2] = {{0, 1}, {1, 0}, {0, -1} , {-1, 0}};
	char heading[4] = { '>', 'v', '<', '^' };
	int start[2] = { 0, 0 };
	int go = 0;
	for (int i = 1; i <= h; i++)
	{
		for (int j = 1; j <= w; j++)
		{
			int cnt = 0;
			if (map[i][j] == '#') {
				// 현재 위치에서 주변의 # 개수 세기
				for (int k = 0; k < 4; k++) {
					if (map[i + dir[k][0]][j + dir[k][1]] == '#') {
						cnt++;
					}
				}

				// 시작점 위치를 찾으면 시작점과 방향을 저장하고 반복문 탈출
				if (cnt == 1)
				{
					start[0] = i;
					start[1] = j;

					for (int k = 0; k < 4; k++) {
						if (map[i + dir[k][0]][j + dir[k][1]] == '#') {
							go = k;
						}
					}

					goto escape;
				}
			}
		}
	}

escape:

	cout << start[0] << ' ' << start[1] << endl;
	cout << heading[go] << endl;

	hashCnt--;
	while (hashCnt != 0) {

		// 로봇이 이동한 지도를 탐색한다.
		for (int k = 0; k < 4; k++) {
			int dh = start[0] + dir[k][0];
			int dw = start[1] + dir[k][1];

			// 이동한 위치를 찾으면 
			if (map[dh][dw] == '#') {
				// 방향을 바꿔야하는지 확인하고
				int diff = go - k;
				if (diff == -1 || diff == 3) {
					cout << 'R';
				}
				else if (diff == 1 || diff == -3) {
					cout << 'L';
				}
				else if (abs(diff) == 2) {
					cout << "LL";
				}
				// 직진 한 번 한 후에
				cout << 'A';

				// 지도에 지나온 곳 지워주고
				map[start[0]][start[1]] = '.';
				map[dh][dw] = '.';

				// # 개수를 빼고 이동한 후 방향을 재지정한다.
				hashCnt-=2;
				start[0] += dir[k][0]*2, start[1] += dir[k][1] * 2;
				go = k;

				break;
			}
		}
	}

	return 0;
}