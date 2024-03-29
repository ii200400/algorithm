// 문제 링크 : https://www.acmicpc.net/problem/10844
// 제출 공유 링크 : http://boj.kr/6f24180cb853409a8a7df2a8e62c58cc
// 백준 쉬운 계단 수

// c 언어를 공부하기 위해서 풀고 있는 문제 (동적 계획법 1)

/*
내가 좋아하는 계단 동적 계획법이다. 재미있어보여서 풀려고 한다.
어.. 차이가 무조건 1인 수가 계단수였다. 오해해서 차이가 일정한 수인줄..
갑자기 재미없어졌다..
*/

#include <stdio.h>

int main(){
  // 계단 길이
  int n;
  // 각 자리의 숫자별로 계단 수의 개수
  // 예를들어 stairs[3][2]는 네자리 수(0부터 시작)이면서 1의 자리수가 2인 숫자로 
  // 만들 수 있는 계단 수의 개수
  int stairs[100][10];

  // 계단 길이와 계단 수의 개수 초기화
  scanf("%d", &n);

  stairs[0][0] = 0;
  for (int i = 1; i < 10; i++)
  {
    stairs[0][i] = 1;
  }
  
  // 계단 길이까지 만들 수 있는 계단 수 계산
  for (int  i = 1; i < n; i++)
  {
    // 0은 이전 숫자가 1, 9는 이전 숫자가 8인 경우에만 계단 수로 만들 수 있으므로
    stairs[i][0] = stairs[i - 1][1];
    stairs[i][9] = stairs[i - 1][8];

    // 나머지 숫자들은 이전 숫자의 +1, -1인 숫자의 경우를 더해 넣는다.
    for (int j = 1; j < 9; j++)
    {
      stairs[i][j] = (stairs[i - 1][j - 1] + stairs[i - 1][j + 1]) % 1000000000;
    }
  }

  // n번째 계단 길이를 만들 수 있는 모든 경우의 합을 구해서
  int sum = 0;
  for (int i = 0; i < 10; i++)
  {
    sum = (sum + stairs[n - 1][i]) % 1000000000;
  }

  // 출력
  printf("%d", sum);

  return 0;
}