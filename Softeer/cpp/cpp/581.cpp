// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=581
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_143136&psProblemId=581
// 소프티어 택배 마스터 광우

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
어우.. n이 3~10인데 잘못봐서 3~50인줄 알고 완전탐색 아니라고 생각해서 해매었다;
완전탐색으로 레일의 모든 순서(순열)를 찾고 그 때의 광우가 옮기는 무게를 계산할 예정이다.

오랫만에 순열 구현하니 조금 버벅였다. 다음에는 변수 햇갈리지 않고 차분히 해야겠다.
*/

#include <iostream>
using namespace std;

// 레일 개수, 바구니 무게, 일의 시행 회수, 정답(답은 2500이하이므로 대충 3000으로 초기화)
int n, m, k, answer = 3000;

// 택배 레일의 전용 무게 배열
int* weights;
// 무게 사용 여부와 레일의 순열 배열
bool* used;
int* ordered;

void permutation(int cnt);
void work();

int main() {
	// 변수와 배열 초기화
	cin >> n >> m >> k;
	
	weights = new int[n];
	used = new bool[n];
	ordered = new int[n];
	for (int i = 0; i < n; i++)
	{
		cin >> weights[i];
		used[i] = false;
	}

	// 레일의 순열 생성
	permutation(0);

	// 정답 출력
	cout << answer << endl;

	return 0;
}

// 레일의 순열을 만드는 재귀함수
void permutation(int cnt) {
	if (cnt == n) {
		work();
		return;
	}

	for (int i = 0; i < n; i++)
	{
		if (used[i])
			continue;

		used[i] = true;
		ordered[cnt] = weights[i];
		permutation(cnt + 1);
		used[i] = false;
	}
}

// 정해진 레일 순서대로 광우가 일을 할 때 옮긴 무게 계산
void work() {
	// 디버깅용
	/*for (int i = 0; i < n; i++)
	{
		cout << ordered[i] << " ";
	}
	cout << endl;*/

	// 일한 회수, 바구니에 담긴 물건의 총 무게, 순열 순번
	int workCnt = 0, basketSum, weightSum = 0, idx = 0;

	// 일한 회수가 k번 일 때까지 일한다.
	do
	{
		basketSum = 0;

		// 바구니에 담긴 무게가 m 이하일 때까지 물건을 담는다.
		do
		{
			basketSum += ordered[idx];
			idx = (idx + 1) % n;
		} while (basketSum + ordered[idx] <= m);

		// 옮긴 무게를 더하고 일한 회수를 1 올린다.
		weightSum += basketSum;
		workCnt++;
	} while (workCnt != k);

	// 이전보다 적은 무게로 일했다면 저장한다.
	if (answer > weightSum)
		answer = weightSum;

	// 디버깅용
	//cout << weightSum << " " << answer << endl;
}