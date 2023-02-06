// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=411
// 제출 링크 : 
// 소프티어 동계 테스트 시점 예측

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
탐색문제로 보인다. dfs나 bfs로 해결하면 될 것 같은데..
dfs로 해결해보겠다.

중간에 틀려서 버스에서 고민해보니.. 
do-while 문으로 작성해서 얼음이 없을 때도 시간이 최소 1초이상으로 출력되는 것을 떠올렸다.
이것만 고치니 맞았다! 야호~
*/

#include <iostream>
using namespace std;

// 화면의 세로, 가로 크기, 얼음 수
int n, m, cnt;
// 맵, 방문여부
int** map;
bool** visited;

// 얼음 탐색
void dfs(int r, int c);
int dir[4][2] = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

int main() {
	cin >> n >> m;

	// 맵, 방문 여부 초기화
	map = new int* [n];
	visited = new bool* [n];
	
	for (int i = 0; i < n; i++)
	{
		map[i] = new int[m];
		visited[i] = new bool[m];
		for (int j = 0; j < m; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == 1)
				cnt++;
		}
	}

	// 시간을 저장하는 변수
	int time = 0;
	// 얼음이 남지 않을때까지 반복한다.
	while (cnt > 0) {
		// 방문여부 초기화
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				visited[i][j] = false;
			}
		}

		// 얼음이 녹는 것을 탐색한다.
		dfs(0, 0);
		time++;
	}

	cout << time << endl;

	// 할당 해제
	for (int i = 0; i < n; i++)
	{
		delete[] map[i];
	}
	delete[] map;

	return 0;
}

void dfs(int r, int c) {
	// 4방위를 탐색하면서
	int dr, dc;
	for (int i = 0; i < 4; i++) {
		dr = r + dir[i][0], dc = c + dir[i][1];
		// 다음 탐색할 곳이 맵 밖을 넘어가면 패스
		if (dr < 0 || n <= dr)
			continue;
		if (dc < 0 || m <= dc)
			continue;

		// 얼음이 있는 장소인데
		if (map[dr][dc] == 1)
		{
			// 2번째 방문(공기와 2면 접촉)이면 얼음이 사라짐을 알 수 있다.
			if (visited[dr][dc]) {
				map[dr][dc] = 0;
				cnt--;
			}
			else { // 얼음이 공기와 1면 접촉이라면 일단 방문처리만 해둔다.
				visited[dr][dc] = true;
			}
		}
		// 얼음이 없는 장소인데 방문하지 않았다면 탐색진행
		else if(!visited[dr][dc]) {
			visited[dr][dc] = true;
			dfs(dr, dc);
		}
	}
}