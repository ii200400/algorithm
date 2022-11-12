// 문제 링크 : https://www.acmicpc.net/problem/2738
// 제출 공유 링크 : http://boj.kr/64cfc91bcf584ce2819d74e984c0b681
// 백준 행렬 덧셈

// c 언어를 공부하기 위해서 풀고 있는 문제 (간단 배열)

/*
n, m이 100보다 작거나 같은 정수이므로
간단하게 크기가 [100][100]인 int 행렬을 만들어서 진행하였다.

함수와 배열 만드는 연습도 할 겸 입력받는 부분을 함수화하엿다.
*/

#include <stdio.h>

void getChar(int a[100][100], int n, int m);

int main(){
  // 행렬의 크기
  int n, m;
  scanf("%d %d", &n, &m);
  // printf("%d, %d", n, m);

  // 두 행렬 초기화
  int a[100][100], b[100][100];
  getChar(a, n, m);
  getChar(b, n, m);

  // 두 행렬의 값을 더해서 출력
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
    {
      printf("%d ", a[i][j] + b[i][j]);
    }
    printf("\n");
  }
  

  return 0;
}

// 입력으로 받은 배열을 초기화하는 함수
// 2차원 배열, 배열의 세로길이, 배열의 가로길이
void getChar(int a[100][100], int n, int m){
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < m; j++)
    {
      scanf("%d", &a[i][j]);
    }
    
  }
}