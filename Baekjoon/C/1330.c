// 문제 링크 : https://www.acmicpc.net/problem/1330
// 제출 공유 링크 : http://boj.kr/4e93a4f55add4e8aa1a3d78cba6f7ecd
// 백준 두 수 비교하기

// c 언어를 공부하기 위해서 풀고 있는 문제 (조건문)

#include <stdio.h>

int main(){
  int num1, num2;

  scanf("%d %d", &num1, &num2);

  if(num1 > num2){
    printf(">");
  }else if(num1 < num2){
    printf("<");
  }else{
    printf("==");
  }

  return 0;
}