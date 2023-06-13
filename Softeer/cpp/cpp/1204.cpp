// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=1204
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=1204&submissionSn=SW_PRBL_SBMS_180156
// 소프티어 슈퍼컴퓨터 클러스터

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
음.. 아무리 생각해봐도 전형적인 이진탐색 문제같다.
ai는 업그레이드를 최대로 해도 20억을 넘지 않을 것 같아서 int형으로 해도 될 것 같다.
B만 long형으로 진행하면 될 것 같다.

어..? long이 8바이트인 줄 알았는데 int와 같은 4바이트이다.
long long으로 바꿔주었다.

오버플로우 때문에 오답이 나오고 있는 것 같다.. 음..

오버플로우를 안나게 할 수가 없어서 그냥 범위에서 넘어가면 break로 탈출하고 값을 처리하도록 만들었다.
그랬더니 통과~
.. 소프티어는 알고리즘이 아니라 데이터 범위나 조건 이해가 더 힘든 것 같다;
*/

#include <iostream>
#include <cmath>
using namespace std;

int main() {
	int n;
	long long b;
	cin >> n >> b;

	int* computers = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> computers[i];
	}

	// from은 가능한 최대 b, to는 불가능한 최소 b
	int from = 1, to = 2000000001;
	// 이진탐색으로 가능한 최대 b를 찾는다.
	loop: while (from + 1 < to) {
		//cout << from << " " << to << endl;
		// 필요한 비용
		long long cost = 0;
		int mid = ((long long) from + to) / 2;
		
		// 필요한 비용을 계산해서
		for (int i = 0; i < n; i++) {
			int diff = mid - computers[i];
			if (diff < 0) continue;
			cost += (long long) diff * diff;

			if (cost > b) break;
		}

		// 비용이 예산 내라면 from에 아니라면 to에 저장하고 계속한다.
		//cout << cost << " " << b << endl;
		if (cost < b) from = mid;
		else if (cost > b) to = mid;
		else {
			from = mid;
			break;
		}
	}

	cout << from << endl;

	delete computers;

	return 0;
}