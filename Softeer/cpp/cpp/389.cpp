// 문제링크 : https://softeer.ai/practice/info.do?idx=1&eid=389
// 제출 링크 : https://softeer.ai/practice/result.do?eventIdx=1&psProblemId=389&submissionSn=SW_PRBL_SBMS_101120
// 소프티어 성적평균

// cpp 언어를 공부하기 위해서 풀고 있는 level 3 문제

/*
cpp은 기억나지 않는데 C언어 코딩공부한 것 때문인지 의외로 잘 풀리고 있다.
이전에 푼 것 같긴하지만 한번 더 풀어보기로 하였다.

문제 자체가 쉬워서 풀이는 적지 않겠다.

소수점 아래 자리를 고정하는 방법만 블로그에서 찾아서 적용하였다.
https://semaph.tistory.com/7
*/

#include <iostream>
// #include <math> 반올림 함수 사용해야하는 줄 알았는데 아니다.
using namespace std;

int main() {
	// 학생 수, 구간 수
	int n, k;
	cin >> n >> k;

	// 현재까지 들어온 n번째 학생까지의 성적 합산을 저장하는 배열
	// 첫 번째는 0으로 초기화
	int* sum = new int[n + 1];
	sum[0] = 0;

	// sum 배열 초기화
	int temp;
	for (int i = 1; i <= n; i++) {
		cin >> temp;
		sum[i] = sum[i - 1] + temp;
	}

	// 구간을 저장할 변수 둘
	int start, end;
	// 소수점 아래 자리수를 두 자리로 고정하였다.
	// 반올림은 자동으로 적용되는 듯 하다.
	cout << fixed;
	cout.precision(2);
	for (int i = 0; i < n; i++) {
		cin >> start >> end;
		// 두 구간 사이의 학생의 합을 학생의 수만큼 나누어 출력
		cout << float(sum[end] - sum[start - 1]) / (end - start + 1) << endl;
	}

	delete[] sum;

	return 0;
}