// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=627
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_146837&psProblemId=627
// 소프티어 이미지 프로세싱

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
아.. 재직자 대회 예선 안 풀려고 햇는데 바로 생각나는 방법이 있어서 풀어보려고 한다.
그런데 진짜로 dfs, bfs로 해결되는 문제인지 의문이다. 계산상으로는 시간초과가 안나기는 하는데
그렇다고 하면 난이도가 너무 쉽다..

어.. 통과했다..
이전 대회 난이도가 너무 높아서 난이도를 낮췄나..?
*/

#include <iostream>
using namespace std;

void dfs(int h, int w, int c, int cij);

int** map;

int main() {
	// 세로, 가로
	int h, w;
	cin >> h >> w;

	// 맵 정보 (외곽을 0으로 초기화)
	map = new int* [h+2];
	for (int i = 1; i <= h; i++)
	{
		map[i] = new int[w + 2] {0};
		for (int j = 1; j <= w; j++)
		{
			cin >> map[i][j];
		}
	}
	map[0] = new int[w + 2] {0}, map[h + 1] = new int[w + 2] {0};

	// 디버깅용
	/*for (int i = 0; i < h+2; i++)
	{
		for (int j = 0; j < w + 2; j++) {
			cout << map[i][j] << ' ';
		}
		cout << endl;
	}*/

	// 연산 회수, 픽셀의 i/j/c
	int i;
	cin >> i;
	int pi, pj, pc;
	// cin을 아래처럼 사용해도 되는지 시도
	for (; i > 0; i--)
	{
		cin >> pi >> pj >> pc;

		// 현재 색과 같은 색으로 바꾸라고 하면 변화가 없으므로 생략한다.
		if (map[pi][pj] == pc) continue;

		int temp = map[pi][pj];
		map[pi][pj] = pc;
		dfs(pi, pj, pc, temp);
		
	}

	// 맵 출력
	for (int i = 1; i <= h; i++)
	{
		for (int j = 1; j <= w; j++) {
			cout << map[i][j] << ' ';
		}
		cout << endl;
	}

	return 0;
}

// dfs 알고리즘으로 주변 색상을 탐색하면서 지정한 색상으로 변경
int dir[4][2] = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
void dfs(int h, int w, int c, int cij) {
	for (int i = 0; i < 4; i++)
	{
		int dh = h + dir[i][0], dw = w + dir[i][1];
		if (map[dh][dw] == cij)
		{
			map[dh][dw] = c;
			dfs(dh, dw, c, cij);
		}
	}
}