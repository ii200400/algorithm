// 문제 링크 : https://www.acmicpc.net/problem/2580
// 제출 공유 링크 : http://boj.kr/092ef8097e7a4554a801668b62da0d9d
// 백준 스도쿠

// c 언어를 공부하기 위해서 풀고 있는 문제 (백트래킹)

/*
중간에 정수론 및 조합론이 있었지만, 그것은 정말..
수학 수식을 공부하고 그대로 코딩하는 방식이라서 코테와는 거리가 멀어 생략하였다.

전역변수로 옮길지 말지 고민하다가 몇몇만 전역변수가 되어버렸다;
예전에는 못 풀었는데.. 어쩌다보니 풀었다;
이전에 너무 어렵게 생각했었나..? 오늘은 운이 좋은 것 같다.
*/

#include <stdio.h>

// 스도쿠에 숫자가 없는 칸의 수
int empty_cnt = 0;
// 가로, 세로, 3x3 정사각형 안에 존재하는 숫자 사용 여부
// 예를 들어 used[0][1][2]는 2번째 가로에 숫자 3의 사용여부
// 인덱스는 0부터 모두 사용하므로 적절하게 +1 혹은 -1을 계산하여 처리한다.
char used[3][9][9];

int solve(int sudoku[9][9], int empty[81][2], int num);

int main(){
  // used 배열 0으로 초기화
  for (int i = 0; i < 3; i++)
  {
    for (int j = 0; j < 9; j++)
    {
      for (int k = 0; k < 9; k++)
      {
        used[i][j][k] = 0;
      }
    }
  }

  // 스도쿠 초기화 및 빈칸의 위치와 개수 초기화
  int sudoku[9][9], empty[81][2];
  for (int i = 0; i < 9; i++)
  {
    for (int j = 0; j < 9; j++)
    {
      int num;
      scanf("%d", &num);
      sudoku[i][j] = num;

      if (num == 0)
      {
        empty[empty_cnt][0] = j;
        empty[empty_cnt++][1] = i;
      }else{
        used[0][i][num-1] = 1;
        used[1][j][num-1] = 1;
        used[2][(i / 3) * 3 + j / 3][num - 1] = 1;
      }
    }
  }

  // 칸 채워넣기
  solve(sudoku, empty, 0);

  // 완성한 스도쿠 출력
  for (int i = 0; i < 9; i++)
  {
    for (int j = 0; j < 9; j++)
    {
      printf("%d ", sudoku[i][j]);
    }
    printf("\n");
  }

  return 0;
}

// 스도쿠 풀기
// 스도쿠 배열, 스도쿠의 빈 곳 배열, 스도쿠의 빈 곳 순서
int solve(int sudoku[9][9], int empty[81][2], int num){
  // 빈 곳의 가로, 세로 위치
  int w = empty[num][0], h = empty[num][1];
  // 빈 곳의 정사각형 순서 계산
  int squre_order = (h / 3) * 3 + w / 3;

  // 빈 곳에 어떤 숫자를 넣을지 탐색한다.
  for (int i = 0; i < 9; i++)
  {
    // 가로, 세로, 해당 정사각형에서 사용하지 않은 숫자라면
    if (!used[0][h][i] && !used[1][w][i] && !used[2][squre_order][i])
    {
      // 스도쿠에 숫자를 기록하고
      sudoku[h][w] = i + 1;

      // 만약 모든 빈곳을 채웠다면 return 1
      if (num + 1 == empty_cnt)
      {
        return 1;
      }

      // 해당 위치에 숫자를 사용하고 있음을 기록한 후
      used[0][h][i] = 1;
      used[1][w][i] = 1;
      used[2][squre_order][i] = 1;

      // 다음 빈 칸을 채워 넣는다.
      if (solve(sudoku, empty, num + 1) == 1){
        // 모든 빈 칸을 채운 경우 return 1
        return 1;
      }

      // 해당 빈 칸의 숫자가 맞지 않았을 경우 숫자를 지우고
      // 사용 기록도 지운 후 스도쿠 풀기를 계속 진행한다.
      sudoku[h][w] = 0;
      used[0][h][i] = 0;
      used[1][w][i] = 0;
      used[2][squre_order][i] = 0;
    }
    
  }  

  return 0;
}