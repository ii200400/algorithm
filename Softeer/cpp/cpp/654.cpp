// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=654
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=654&submissionSn=SW_PRBL_SBMS_180146
// 소프티어 통근버스 출발 순서 검증하기

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
친절하게 2 3 1 로 줄지어있는 버스는 조건에 맞게 나가지 못한다는 점을 문제에서 설명하고 있다.
어떤 것을 출력하는지 이해를 못하고 있었는데 입출력예제4번으로 이해했다.

단순히 순열을 구현하고 조건에 맞는지 확인하면 될 것 같은데, 
순열로 숫자를 3개만 선택하면 되는 것이라 3중 for문으로 할지 재귀로할지 고민되었다.
for문으로 순열을 해결한 경험이 많이 없어서 for문을 사용해보기로 했다.

-------1차 시도---------

시간초과로 20점밖에 얻지 못했다. 생각하고 보니 거의 오름차순인 5000개의 버스에 대해서는
계산이 100억정도?달하는 것을 알 수 있었다. 빅-오 로 계산하면 1천억..
빠르게 계산하기 위한 방법이 필요했다.

배열을 2개 사용해서 해결해보기로 하였다... 아니다 1개만 사용해도 된다. 방법은 아래와 같다.
버스 숫자가 사용되었는지 판단을 위한 bool 배열 하나를 만든다. 예를 들어서 n=3일 때 숫자가 2인 버스가 사용되었다면 0 0 1 인 것이다.
이 방법으로 자신(ai)보다 작은 숫자가 몇 개 있는지 세면서 진행한다. 
작은 숫자들은 ak의 수이고 조건에 맞는 aj를 만날 때마다 더해줄 것이다. 
이렇게 하면 해당하는 숫자가 없을 때 빠르게 알아채고 반복문을 나올 수 있어 빨라진다!
코드에서는 cnt 변수를 사용했다.

-------2,3차 시도---------

변수명을 중복으로 사용하는 줄 모르고 테스크2에서 틀렸다. 그런데 다 고친것 같은데도 계속 틀리는데 왜인지 모르겠다.

검색했더니 answer 변수가 int를 넘어갈 수 있어 생긴 문제였다는 것을 알 수 있었다.
내가 이것도 확인 안 했다니.. 할 말이 없다; 4번째에서 정답을 얻을 수 있었다.

재미는 있었는데 아이고 두야.. 머리가 아프다;

*/

#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	int* numbers = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> numbers[i];
	}

	// 버스 숫자를 탐색 여부 bool 배열 (false로 초기화)
	bool* check = new bool[n + 1];
	for (int i = 0; i < n + 1; i++) {
		check[i] = false;
	}

	long answer = 0;
	// 조건에 맞는 순열(i, j, k)인지 확인하면서 조건에 맞는 것을 기록해두기
	for (int i = 0; i < n - 2; i++) {
		cout << numbers[i] << endl;

		// 현재 버스 탐색 중이니 true로 변경
		check[numbers[i]] = true;
		// ai > ak를 만족하는 숫자들의 개수
		int cnt = 0;

		/*
		cout << "check :";
		for (int m = 1; m < n + 1; m++) {
			cout << " " << check[m];
		}
		cout << endl;
		*/

		// 이미 탐색한 버스를 제외하고 ai보다 작은 수를 가지는 버스의 수
		for (int m = 1; m < numbers[i]; m++) {
			if (check[m] == false) cnt++;
		}

		//cout << "cnt: " << cnt << endl;

		for (int j = i + 1; j < n - 1 && cnt != 0; j++) {
			// aj가 ai보다 작다면 조건에 맞지 않기 때문에 continue
			// ai보다 작은 수를 가지는 버스의 수도 줄기 때문에 cnt -1
			if (numbers[i] > numbers[j]) {
				cnt--;
				continue;
			}

			// 조건에 만족하는 버스 수 만큼 cnt를 answer에 합해준다.
			answer += cnt;
		}

		//cout << "answer : " << answer << endl;
	}

	cout << answer << endl;

	delete numbers;
	delete check;

	return 0;
}