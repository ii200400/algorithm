// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=1309
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_181246&psProblemId=1309
// 소프티어 성적 평가

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
정렬 자체는 문제가 없는데, 정렬 후 입력 순서에 맞게 출력하는 것이 문제이다.
정렬이 되지 않은 배열과 정렬된 배열로 나누고 
정렬된 배열을 순차적으로 살펴보면서 전 값과 다른 값이 나오면 키(점수):값(순위)으로 저장한 후,
정렬되지 않은 배열을 순차적으로 살펴보면서 위에서 저장한 map을 참고하여 출력하면 되겠다.
메모리를 좀 소비하기는 하지만, 간단하게 해결할 수 있을 것 같다.
*/

#include <iostream>
#include <unordered_map>
using namespace std;

// https://en.cppreference.com/w/c/algorithm/qsort
int compare_ints(const void* a, const void* b)
{
	int arg1 = *(const int*)a;
	int arg2 = *(const int*)b;

	// 내림차순을 위해 -1을 1로, 1을 -1로 변경
	if (arg1 < arg2) return 1;
	if (arg1 > arg2) return -1;
	return 0;

	// return (arg1 > arg2) - (arg1 < arg2); // possible shortcut
	// return arg1 - arg2; // erroneous shortcut (fails if INT_MIN is present)
}

int main() {
	// 사람 수
	int n;
	cin >> n;
	// 3개의 대회에서 각 사람들의 점수 총합
	int* scoreSum = new int[n];
	// 사람들이 받은 점수 배열, 해당 배열을 정렬한 배열
	int* score = new int[n];
	int* sortedScore = new int[n];
	// 키(점수):값(순위) 를 저장하는 map 변수
	unordered_map<int, int> m;

	// scoreSum 초기화
	for (int i = 0; i < n; i++) {
		scoreSum[i] = 0;
	}

	// 3개의 대회가 있으므로 3번 반복
	for (int i = 0; i < 3; i++) {
		// 입력값 받기
		for (int i = 0; i < n; i++) {
			cin >> score[i];
			sortedScore[i] = score[i];
			scoreSum[i] += score[i];
		}

		// 퀵소트로 정렬
		qsort(sortedScore, n, sizeof(int), compare_ints);

		// 이전 숫자를 저장하는 변수, 해당 숫자가 몇 번째 등수인지 저장하는 변수
		int temp = -1, rank = 0;
		for (int i = 0; i < n; i++) {
			rank++;
			if (temp != sortedScore[i]) {
				temp = sortedScore[i];
				m[temp] = rank;
			}
		}

		for (int i = 0; i < n; i++) {
			cout << m[score[i]] << ' ';
		}
		cout << endl;

		m.clear();
	}

	//마지막으로 총합을 위와 같은 방법으로 출력한다.
	for (int i = 0; i < n; i++) {
		sortedScore[i] = scoreSum[i];
	}

	qsort(sortedScore, n, sizeof(int), compare_ints);

	int temp = -1, rank = 0;
	for (int i = 0; i < n; i++) {
		rank++;
		if (temp != sortedScore[i]) {
			temp = sortedScore[i];
			m[temp] = rank;
		}
	}

	for (int i = 0; i < n; i++) {
		cout << m[scoreSum[i]] << ' ';
	}

	delete scoreSum;
	delete score;
	delete sortedScore;

	return 0;
}