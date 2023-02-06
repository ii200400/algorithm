// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=390
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=390&submissionSn=SW_PRBL_SBMS_101428
// 소프티어 징검다리

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
객체를 사용해보고 싶어서 사용해보았다. 아래의 블로그를 참고하였다.
https://ffoorreeuunn.tistory.com/366
*/

#include <iostream>

using namespace std;

// 현재 돌의 높이와 현재 돌을 밟으면서 이곳까지 가장 많이 밟은 돌의 수
class HeighestStep
{
public:
	int height;
	int step;
};
/* 예전에는 아래와 같이 작성하였다.
	struct heightStep
	{
		int height;
		int step;
	};
*/
int main() {
	int n;
	cin >> n;
	
	// 각 위치의 돌의 정보 배열
	HeighestStep* heighestStep = new HeighestStep[n];
	for (int i = 0; i < n; i++)
	{
		cin >> heighestStep[i].height;
	}
	// 가장 첫 돌은 무조건 현재 돌까지 1개만 밟을 수 있으므로
	heighestStep[0].step = 1;
	
	// 현재 돌 이전의 돌 중 높이가 더 낮으면서 가장 큰 step을 저장하는 변수
	int maxStep;
	// 정답을 저장하는 변수
	int answer = 1;
	for (int i = 1; i < n; i++)
	{
		maxStep = 0;

		// maxStep을 찾고
		for (int j = 0; j < i; j++) {
			if (heighestStep[j].height < heighestStep[i].height && maxStep < heighestStep[j].step)
			{
				maxStep = heighestStep[j].step;
			}
		}
		// i 번째(현재 돌)의 step에 +1하여 저장한다.
		heighestStep[i].step = maxStep + 1;
		//cout << heighestStep[i].step << endl;
		// 현재 돌의 step이 가장 크면 answer에 저장한다.
		if (answer < heighestStep[i].step)
		{
			answer = heighestStep[i].step;
		}
	}

	// 정답 출력
	cout << answer << endl;

	delete[] heighestStep;

	return 0;
}