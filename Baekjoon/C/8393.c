// 문제 링크 : https://www.acmicpc.net/problem/8393
// 제출 공유 링크 : http://boj.kr/2f9a6a62426242acb8eacb443c5b5123
// 백준 합

// c 언어를 공부하기 위해서 풀고 있는 문제 (반복문)

#include <stdio.h>

int main(){
  int n;

  scanf("%d", &n);

  int cnt = 0;
  for(int i = 1; i<=n; i++){
    cnt += i;
  }

  // printf("%d\n", n*(n+1)/2);
  printf("%d\n", cnt);

  return 0;
}