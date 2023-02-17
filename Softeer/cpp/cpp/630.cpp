// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=630
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=630&submissionSn=SW_PRBL_SBMS_147216
// 소프티어 코딩 테스트 세트

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
오..! 이진탐색 오랫만에 본다.
최대값 초기화를 어떻게 할지만 고민하고 진행하면 될 것 같다.

1차
알고리즘이 잘못된 것 같지는 않은데 오답이 꽤 나와서 보니..
min과 max의 초기값이 잘못되어있다.

2차
아하? 정답이 늘어나기는 했지만 여전히 많다.
수식이 복잡해서 좀.. 잘못되었을 수도 있다. 다시보자.

아늬.. long 이여야 할 변수 하나가 int이다;

3차
정답이 아-주 많아졌으나, 오답이 여전히 남아있다.
도대체 웨지..감자..
아! 1차때 재설정했던 max가 1500.. 정도이면 될 줄 알았는데 다시 생각해보니.. 166666.. 이 최대값이다!
잘 모르겠어서 그냥 2000.. 으로 설정했다!

마참내,. 통과..
초기값 설정과 변수 타입만 잘못써서 이ㅏ 난리라니 아하하하하핳!
*/

#include <iostream>
using namespace std;

int main() {
	// 난이도 개수, 난이도 별 문제 수
	int n, tn;
	cin >> n >> tn;

	// 시나리오 수 만큼 반복 (인덱스 0과 2n은 0으로 둔다.)
	long long* problemNums = new long long[2 * n + 1];
	for (int i = 0; i < tn; i++)
	{
		// 난이도별 문제 수 초기화
		problemNums[0] = 0, problemNums[2*n] = 0;
		long long min = 0, max = 2000000000001;
		for (int j = 1; j < 2 * n; j++)
		{
			cin >> problemNums[j];
		}

		// 이진탐색 시작
		search: while (min + 1 < max) {
			long long mid = (min + max) / 2;
			long long temp = 0;

			// 배열을 탐색하면서 mid를 충당 가능한지 확인한다.
			for (int i = 1; i < 2 * n; i+=2) {
				// 문제 세트만들기에 부족하다면 d문제들을 가져와 사용한다.
				long long have = temp + problemNums[i];
				if (mid > have)
				{
					// 만들 수 없다면 다른 값을 탐색하러 가버린다.
					if (problemNums[i+1] < mid - have)
					{
						max = mid;
						goto search;
					}
					else { // n-n+1 와 같은 남은 d문제들을 저장한다.
						temp = problemNums[i + 1] - (mid - have);
					}
				}
				else { // 남은 d 문제들을 저장한다.
					temp = problemNums[i + 1];
				}
			}

			// mid 만큼의 테스트 세트 문제를 만들 수 있다면 저장한다.
			min = mid;
		}

		// 가능한 최대 코딩 테스트 세트 수 출력
		cout << min << endl;
	}

	return 0;
}