// 문제 링크 : https://www.acmicpc.net/problem/10807
// 제출 공유 링크 : http://boj.kr/f329d5d21ed94e43995084183b40e2b6
// 백준 개수 세기

// c 언어를 공부하기 위해서 풀고 있는 문제 (배열)

#include <stdio.h>

int main(){
  int n;
  int cnt[201] = {0};
  scanf("%d", &n);

  int num;
  for(int i = 0; i<n; i++){
    scanf("%d", &num);
    cnt[num+100] += 1;
  }

  int v;
  scanf("%d", &v);
  printf("%d\n", cnt[v+100]);

  return 0;
}