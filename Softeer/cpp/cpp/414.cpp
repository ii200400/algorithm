// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=414
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&submissionSn=SW_PRBL_SBMS_143270&psProblemId=414
// 소프티어 스마트 물류

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
음.. 일단 로봇은 앞에있는 부품들부터 집는 것이 다음 있는 로봇에게 더 넓은 선택폭을 제공하므로 
최대한 앞의 부품들부터 집는 것으로 한다.
스택 2개를 활용해서 하나는 부품을 저장하도록 다른 하나는 로봇을 저장하도록 만들 예정이다.
*/

#include <iostream>
#include <queue>

using namespace std;

int main() {
	// 라인의 길이, 부품을 집을 수 있는 거리
	int n, k;
	cin >> n >> k;

	// 탐색한 로봇과 부품을 k거리 만큼 저장하는 스택
	queue<int> robots, parts;
	// 임시로 입력을 저장하는 변수, 부품을 집은 로봇 수
	char c;
	int cnt = 0;

	// 순서대로 들어오는 부품이나 로봇을 큐에 저장하거나 빼면서 
	// 몇개의 로봇이 부품을 집었는지 센다.
	for (int i = 0; i < n; i++)
	{
		cin >> c;
		if (c == 'H')	// 부품
		{
			if (robots.size() > 0) {
				robots.pop();
				cnt++;
			}
			else {
				parts.push(i);
			}
		}
		else { // 로봇
			if (parts.size() > 0) {
				parts.pop();
				cnt++;
			}
			else {
				robots.push(i);
			}
		}

		// 너무 먼 부품이나 로봇은 큐에서 뺀다.
		if (robots.size() > 0 && i - robots.front() >= k)
			robots.pop();
		if (parts.size() > 0 && i - parts.front() >= k)
			parts.pop();
	}

	// 로봇이 집은 부품의 수 출력
	cout << cnt << endl;

	return 0;
}