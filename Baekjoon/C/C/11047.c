// 문제 링크 : https://www.acmicpc.net/problem/11047
// 제출 공유 링크 : http://boj.kr/dd7ac991055a42909ed9594b2897d979
// 백준 동전 0

// c 언어를 공부하기 위해서 풀고 있는 문제 (그리디 알고리즘)

/*
i ≥ 2인 경우에 Ai는 Ai-1의 배수 라는 조건이 있어서 
간단한 그리디 문제라는 것을 쉽게 알 수 있었다.
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
  // 동전 종류의 수, 동전의 합
  int n, k;
  scanf("%d %d", &n, &k);

  // 동전 가치 배열
  int *coins = (int *)malloc(sizeof(int *) * n);
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &coins[i]);
  }

  // 필요한 동전의 개수
  int sum = 0;
  // 가치가 큰 동전들을 우선으로 필요한 동전의 개수를 구한다.
  for (int i = n-1; i >= 0; i--)
  {
    sum += k / coins[i];
    k %= coins[i];
  }

  // 동전의 개수를 출력
  printf("%d", sum);

  return 0;
}