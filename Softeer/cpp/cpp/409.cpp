// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=409
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_233578&psProblemId=409
// 소프티어 장애물 인식 프로그램

// 쉬어갈겸 푸는 level 2문제

/*
다섯번째 레벨 2 문제

풀다가 코딩테스트 진행하고 그대고 까먹었나보다. 이어서 진행하겠다.
생각하는 그대로 진행해서 원활하게 통과하였다.
블록의 장애물 세는 코드를 좀 세롭게 해보았는데.. 역시 알고리즘할 때는 전역변수가 더 쉬운것 같다.
*/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int dx[4] = { 0, 0, -1, 1 };
int dy[4] = { 1, -1, 0, 0 };

// 가로 길이
int n;

// 0과 1 밖에 없어서 그냥 bool 배열로 만들었다.
// 지도 변수
vector<bool>* map;

// 블록탐색, 블록의 장애물 수를 반환한다.
int dfs(int x, int y, int cnt) {
	for (int i = 0; i < 4; i++) {
		int nx = dx[i] + x;
		int ny = dy[i] + y;

		// 맵 밖을 탐색하거나 장애물이 없다면 생략
		if (ny < 0 || ny >= n || nx < 0 || nx >= n || !map[ny][nx])
			continue;

		map[ny][nx] = 0;
		cnt = dfs(nx, ny, cnt+1);
	}

	return cnt;
}

int main() {
	cin >> n;

	map = new vector<bool>[n];
	for (int i = 0; i < n; i++) {
		// 입력 사이사이에 띄어쓰기가 없어서 string 형으로 모두 받아온 후
		string temp;
		cin >> temp;

		// 문자가 1이 맞으면 true를 아니면 false를 입력하도록 만듦
		for (int j = 0; j < n; j++) {
			map[i].push_back(temp[j]=='1');
		}
	}

	// 디버깅용
	/*
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << map[i][j];
		}
		cout << endl;
	}
	*/

	vector<int> blockCnt;
	// 장애물을 찾았다면 블록을 찾고 장애물 수를 저장한다.
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (map[i][j]) {
				map[i][j] = 0;
				blockCnt.push_back(dfs(j, i, 1));
			}
		}
	}

	sort(blockCnt.begin(), blockCnt.end());

	cout << blockCnt.size() << endl;
	for (int i = 0; i < blockCnt.size(); i++) {
		cout << blockCnt[i] << endl;
	}

	// 메모리 해제, 도중에 에러가 있었는데 delete를 잘못 사용하고 있었다.
	// https://stackoverflow.com/questions/53057590/cant-delete-pointer-has-triggered-a-breakpoint
	delete[] map;

	return 0;
}