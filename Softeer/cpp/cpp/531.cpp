// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=531
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_148486&psProblemId=531
// 소프티어 사물인식 최소 면적 산출 프로그램

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
어.. 완전탐색 같다. 이건 계산으로 할 수 있는 것이 아니다;
그런데..x와 y의 범위가 -1000~1000 이라서 가능한 모든 직사각형을 만들면서 모두 탐색하면 시간초과가 넉넉하게 일어난다.
각 색상별 점을 하나씩 선택해서 최소한의 직사각형을 만드는 방법도 시간초과가 넉넉하게 생긴다.
간단히 10개의 색상마다 10개의 점이 있다면 10^10이다; 20개의 색상마다 5개의 점이 있다면 5^20(1조를 넘음)이다.
쓰읍.. 이진탐색인가? 아닌것 같다. 아무리 생각해도 이런 문제는 이진탐색이.. 아닌 것 같다.
사각형의 선분은 4개인데 위, 아래 선분의 조건을 맞추면서 4개 모두 이진탐색을 넣는다? 
세상에나.. 학생이 풀 난이도가 아닌 것 같다.

그럼.. 뭐지?

검색해서 보니 두번째 생각했던 색상마다 점을 선택하는 방법으로 풀린다고 한다.
..? 제한조건 잘 못 주신거 아니신지 의심했다.. 일단 풀어보겠다.

1차
역시 시간초과가 생겼다. 그럼 가지치기 방법으로 시간을 줄이는 방법밖에는 없다.
결과에 도달하기 전에 해당 점들이 답이 아니라는 것을.. 알 수 있구나? 아하하하하!

통과하였다. 호홓.. 완전탐색 시간복잡도는 이론상 전부가 아님을 기억해야겠다.
*/

#include<iostream>
#include<list>

using namespace std;

void dfs(int fromX, int toX, int fromY, int toY, int cnt);

// 각 색상마다 점을 저장하는 변수
list<int*>* dotSet;
// 점들이 가질 수 있는 색깔의 총 개수, 정답
int k, answer = 4000000;

int main()
{
	// 점의 개수
	int n;
	cin >> n >> k;

	// 각 색상마다 점을 저장하는 변수
	dotSet = new list<int*>[k + 1];
	for (int i = 1; i <= k; i++) {
		list<int*> templist;
		dotSet[i] = templist;
	}

	// dotSet 초기화
	int x, y, color;
	for (int i = 0; i < n; i++) {
		cin >> x >> y >> color;
		dotSet[color].push_back(new int[2] {x, y});
	}

	dfs(1001, -1001, 1001, -1001, 1);

	cout << answer << endl;

	return 0;
}

// 직사각형의 각 선분 4개와 각 색상별 점을 선택한 회수
void dfs(int fromX, int toX, int fromY, int toY, int cnt) {
	// 모든 색상의 점을 선택했다면 직사각형의 너비를 계산하여 저장
	if (k + 1 == cnt) {
		if (answer > (toX - fromX) * (toY - fromY))
			answer = (toX - fromX) * (toY - fromY);

		return;
	}

	// cnt 번째 점을 선택한다.
	for (auto it : dotSet[cnt]) {
		// cout << it[0] << ' ' << it[1] << endl;
		int tempFx = fromX, tempTx = toX, tempFy = fromY, tempTy = toY;

		// 점의 위치에 맞게 사각형의 선분을 조정하고
		if (it[0] < tempFx) tempFx = it[0];
		if (tempTx < it[0]) tempTx = it[0];
		if (it[1] < tempFy) tempFy = it[1];
		if (tempTy < it[1]) tempTy = it[1];

		// 사각형 크기는 점을 선택할 때마다 커지기만 하므로 벌써부터 예비 정답보다 크다면 생략한다.
		if (answer <= (tempTx - tempFx) * (tempTy - tempFy)) continue;

		// 다음 색상의 점을 선택하러 간다.
		dfs(tempFx, tempTx, tempFy, tempTy, cnt + 1);
	}

	return;
}