// 문제 링크 : https://www.acmicpc.net/problem/2630
// 제출 공유 링크 : http://boj.kr/6f1438a1dba5432d99f61da1a231e60f
// 백준 색종이 만들기

// c 언어를 공부하기 위해서 풀고 있는 문제 (분할 정복)

/*
쿼드트리라는 것을.. 활용하라고 설명에 적혀있었는데 그것이 무엇인지 모르지만,
일단 분할 정복 기본문제이니 풀어보기로 하였다.

풀고나서 생각났는데 int가 아니라 char형으로 한다는 것을 까먹었다;
*/

#include <stdio.h>
#include <stdlib.h>

void divide_paper(int **paper, int *paper_num, int x_from, int x_to, int y_from, int y_to);

int main(){
  // 전체 종이의 한 변의 길이
  int n;
  scanf("%d", &n);

  // 하얀색 종이의 개수와 파란색 종이의 개수
  int paper_num[2] = {0, 0};
  // 종이의 색상(2차원 동적배열)
  int **paper = (int**)malloc(sizeof(int*) * n);
  for (int i = 0; i < n; i++)
  {
    paper[i] = (int *)malloc(sizeof(int) * n);
  }

  // paper 초기화
  for (int i = 0; i < n; i++)
  {
    for (int j = 0; j < n; j++)
    {
      scanf("%d", &paper[i][j]);
    }
    
  }
  
  // 잘라진 하얀색 색종이와 파란색 색종이의 개수 구하기
  divide_paper(paper, paper_num, 0, n, 0, n);

  // 햐얀색 색종이의 개수와 파란색 색종이의 개수 출력
  printf("%d\n%d\n", paper_num[0], paper_num[1]);

  return 0;
}

// 잘라진 하얀색 색종이와 파란색 색종이의 개수를 분할정복으로 구하는 함수
// 2차원 색종이 색상 배열, 각 색상의 색종이 개수 배열, 분할정복 가로/세로 범위 4개 (_from <=  < _to)
void divide_paper(int **paper, int *paper_num, int x_from, int x_to, int y_from, int y_to){
  char is_same = 1; // 현재 살펴보는 범위 내의 색종이 색상이 모두 같은지 여부
  int color = paper[y_from][x_from];  // 색종이 색상 (0이 하얀, 1이 파란)

  // 모든 범위가 같은 색상인지 탐색
  for (int i = y_from; i < y_to; i++)
  {
    for (int j = x_from; j < x_to; j++)
    {
      // 같은 색상이 아닌 곳이 있다면 2중 반복문 탈출
      if (paper[i][j] != color){
        is_same = 0;
        goto jump;
      }
    }
  }

  jump:

  // 모두 같은 색상이었다면
  if (is_same)
  { // 해당 색상의 종이 수 +1
    paper_num[color]++;
  }else{
    // 그렇지 않다면 사등분하여 같은 방식으로 진행
    int x_mid = (x_from + x_to) / 2;
    int y_mid = (y_from + y_to) / 2;
    divide_paper(paper, paper_num, x_from, x_mid, y_from, y_mid);
    divide_paper(paper, paper_num, x_mid, x_to, y_from, y_mid);
    divide_paper(paper, paper_num, x_from, x_mid, y_mid, y_to);
    divide_paper(paper, paper_num, x_mid, x_to, y_mid, y_to);
  }
}