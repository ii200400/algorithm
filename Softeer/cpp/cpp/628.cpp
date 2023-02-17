// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=628
// 제출 링크 : 
// 소프티어 마이크로서버

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
문제를 읽었을 때 왜 쓸대없이 메모리 크기가 1000이라고 설명하고 사실은 900만 쓸 수 있다고 한지 잘 모르겠다.
함정..인가?

일단 절대 조합은 아니다. 시간초과가 넉넉하게 일어난다.
왠지 정렬을 해서 순차적으로 채워나가면 좋을 것 같다. 음.. 탐욕법처럼?
그런데 이게.. 방법이 맞는지 모르겠다. 이래서 탐욕법이 곤란하다;

1차 
오답과 시간제한초과의 향연이 하핳..
입력받고 정렬하는 부분까지는 맞다고 거의 확신이 드는데.. 조금 더 고민해보고 해보아야겠다.
알고튜터에도 강의가 있으니 봐야겠다.

생각해보니 탐욕법 같은 것이 아니라.. 메모리 크기가 300~600이고 서버 크기가 900이니
메모리가 601이상인 서비스는 무조건 서버 하나를 가져야하고
나머지 서버는 투 포인터 비슷하게 진행해서 n^2가 아니라 n 시간만에 가능할 것 같다.

2차
위의 방법으로 시간초과는 없앴는데 오답이 나왔다.
음.. 인덱스를 이동하거나 계산할 때 잘못한 부분이 있는지 보아야겠다.

생각을 조금 해보니 너무 세부 알고리즘을 단순하게 만들었던 것 같다.
300~450 수들끼리는 서로 어떤 수들끼리 묶여도 문제 없고 451~600 수들은 300~449 와 묶여서 사용되는 것이 가장 가성비?가 좋다.
그래서 450만 2개씩 따로 수를 서버에 넣어주고 450~600 들은 300~449수들과 우선적으로 묶어준후
남은 300~449끼리 묶어서 서버 수를 계산하면 될 것 같다.

3차
쓰읍.. 점수가 더 떨어졌다;; 451~600 수들과 300~449 와 묶어주는 알고리즘이 잘못된것 같아서 봤더니
잘못된게 맞다..
아이고난.. 알고튜터보고 비슷하게 만드는게 좋을 것 같다.
그리고 재직자 예선 문제는 3레벨 중에서도 차이날 정도의 고수준 문제밖에 없다고 판단되어서 다음에는 풀지 않으려고 한다.

*/

#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	// 테스트 케이스 수, 서비스 수
	int T, n;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		cin >> n;

		// 서비스 별 메모리 크기
		int* services = new int[n];
		// 필요한 서버 수
		int serverCnt = 0;
		// 메모리가 301~449인 서비스/450인 서비스/300인 서비스 수
		int cnt450 = 0, cntL450 = 0, cnt300 = 0;
		// 임시 변수, 탐색할 필요가 있는 서비스 수
		int temp, size = 0;
		for (int i = 0; i < n; i++) {
			cin >> temp;
			if (temp > 600) {
				serverCnt++;
			}
			else {
				services[size++] = temp;
				if (temp == 300) cnt300++;
				else if (temp == 450) cnt450++;
				else if (300 < temp && temp < 450) cntL450++;
			}
		}

		// 정렬을 진행해주고 
		sort(services, services + size);

		// 디버깅용
		/*for (int i = 0; i < size; i++) {
			cout << services[i] << ' ';
		}
		cout << endl;*/

		// 450 메모리를 사용하는 서비스부터 2개씩 묶어 서버에 올린다.
		// 아래는 합해서 900이하인 서비스인지 탐색할 때 사용할 포인트(투 포인터)
		int point1 = 0, point2 = 0;
		if (cnt450 > 2) {
			temp = cnt450 / 2;
			serverCnt += temp;
			point2 = temp * 2;
		}
		
		// 450~600 들은 300~449수들과 우선적으로 묶어준다.
		for (point1 += cnt300 + cntL450 - 1, point2 += point1 + cnt450 + 1; point2 < size && 0 <= point1;)
		{
			if (services[point1] + services[point2] <= 900) {
				if (services[point1] == 300) cnt300--;
				else cntL450--;

				serverCnt++;
				point1--, point2++;
			}
			else {
				point1--;
			}
		}

		// 남은 서비스들 서버에 추가
		// 450~ 서비스들 추가
		serverCnt += size - point2;

		// 300 서버들 3개씩 묶어서 추가
		if (cnt300 >= 3)
		{
			serverCnt += cnt300 / 3;
			cnt300 = cnt300 % 3;
		}
		// 300~449 서비스들 2개씩 묶어서 추가
		serverCnt += (cnt300 + cntL450) / 2;
		// 마지막으로 남은 서비스가 있다면 추가
		serverCnt += (cnt300 + cntL450) % 2;

		// 필요한 서버 수 출력
		cout << serverCnt << endl;

		delete[] services;
	}

	return 0;
}