// 문제 링크 : https://www.acmicpc.net/problem/2331
// 제출 공유 링크 : http://boj.kr/
// 백준 분해합

// c 언어를 공부하기 위해서 풀고 있는 문제 (브루트 포스)

/*
원래는 정렬 이후에 재귀 파트가 있었으나.. 
다양한 정렬 알고리즘을 구현 하면서 재귀까지 같이해서 생략하였다.

자연수 자신과 각 자리수를 더했을 때 원하는 수가 나오는지 확인하는 부르트포스인데..
1부터 시작하기에는 조금 과한 것 같고 현재 자리수 * 9 만큼 뺀 숫자부터 현 숫자까지만 탐색하도록 하였다.
*/

#include <stdio.h>
#include <math.h>

int main(){
    int n;
	scanf("%d", &n);

	int len = log10(n);
	//printf("%d", len);

	int left;	// 숫자의 각 자리수를 뽑아내기 위해 사용하는 두 변수
	int sum;	// 각 자리수의 합
	int i;

	// 대충.. 자리수의 개수 * 9를 n에서 뺀 수부터 n까지 탐색한다.
	for (i = n - 9 * (len + 1); i < n; i++) {
		// 먼저 탐색 중인 수의 각 자리수의 합을 구하고
		left = i;
		sum = 0;
		while (left) {
			sum += left % 10;
			left /= 10;
		}

		// 탐색 중인 수와 그 수의 각 자리수의 합을 더해 n과 같은지 확인한다.
		if (i + sum == n) {
			printf("%d", i);
			return 0;
		}
	}

	printf("0");

	return 0;
}