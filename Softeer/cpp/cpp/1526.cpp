// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=1526
// 제출 링크 : 
// 소프티어 염기서열 커버

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
어.. 사람이 문제의 조건에 맞는 초염기서열을 구하는 방식과 같이 만들면 될 것 같다.
문제는 연산속도를 줄이기 위해서 조건을 조금 추가해야 한다는 것 정도이지 않을까..?

몇 개의 염기서열을 조합해서 초염기서열을 만든다. 
물론 a..tt 와 gc... 는 첫번째 자리부터 충돌되므로 불가능하고 
a..tt와 a.g.t 같이 서로 충돌이 일어나지 않는 것들로 만들어보는 방식으로.. 완전탐색을 진행하는데
도중에 구한 초염기서열의 개수보다 초과하면 return 하는 방식으로 연산을 줄인다.

요즘 힘들어서 그런지 아직 코딩을 안했는데도 벌써 머리가 아프다;

---1차 시도---
전체 로직은 틀리지 않은 것 같은데 세부적인 부분에서 잘못된 것인지 정답도 오답도 자주 나온다.

string 초기화를 실수한 부분을 찾았다. 고쳐주기는 했는데
정답나온 것은 어떻게 정답이 나온건지..

---2차 시도---
초기화와 무관하게 틀린 것이 같다. 초기화 문제가 아니었나보다; (이것대로 신기하네..)

아하! 다음 염기서열 후보를 찾는 for문에서 방문처리에 실수하였다.

---3차 시도---
결과로 정답이 늘고 시간초과가 생겼다. 
직전에 풀던 문제도 그렇고 시간초과가 왜이리 많이 나는지;

*/

#include <iostream>
#include <string>
using namespace std;

// 염기서열 수와 길이
int n, m;
// 염기서열 정보
string* order;
// 염기서열 사용 여부
bool* visited;
// 정답
int answer;

// 초염기서열을 만들 수 있으면 만들기
// 초염기서열 후보, 섞을 염기서열 인덱스, 새로만든 초염기서열 저장 변수
bool making(string superOrder, int num, string* temp) {
	// superOrder와 order[num]을 조합할 수 있는지 본다.
	for (int i = 0; i < m; i++) {
		if (superOrder[i] == '.') {
			(*temp)[i] = order[num][i];
		}
		else if (order[num][i] == '.') {
			(*temp)[i] = superOrder[i];
		}
		else if (superOrder[i] == order[num][i]) {
			(*temp)[i] = superOrder[i];
		}
		else {
			// 안 되면 false 반환
			return false;
		}
	}

	// 되면 true 반환
	return true;
}

// 탐색시작할 인덱스, 사용중인 염기서열 개수, 만든 초염기서열 개수, 현재 만드는 중인 초염기서열
void dfs(int from, int used, int sNum, string superOrder) {
	// cout << "sNum: " << sNum << ", super : " << superOrder << endl;

	// 정답 후보가 아니라면 return
	if (answer <= sNum) return;

	// 모든 염기서열을 사용했다면 결과를 저장하고 탐색을 계속한다.
	if (used == n) {
		answer = sNum;
		return;
	}

	// 초염기서열을 일시적으로 저장하는 변수
	string temp(m, '.');
	// 초염기서열을 찾아본다.
	for (int i = from; i < n; i++) {
		if (visited[i]) continue;

		if (making(superOrder, i, &temp)) {
			visited[i] = true;
			dfs(i + 1, used+1, sNum, temp);
			visited[i] = false;
		}
	}

	// 현재 초염기서열 탐색을 끝내고 다음 염기서열 후보를 찾는다.
	for (int i = sNum; i < n; i++) {
		if (visited[i]) continue;

		visited[i] = true;
		dfs(i + 1, used + 1, sNum + 1, order[i]);
		visited[i] = false;
	}
}

int main() {
	cin >> n >> m;
	answer = n;

	// 염기서열 정보
	order = new string[n];
	visited = new bool[n];
	for (int i = 0; i < n; i++) {
		cin >> order[i];
		visited[i] = false;
	}

	// 염기서열 탐색 시작
	visited[0] = true;
	dfs(1, 1, 1, order[0]);

	cout << answer << endl;

	return 0;
}