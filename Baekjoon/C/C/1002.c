// 문제 링크 : https://www.acmicpc.net/problem/1002
// 제출 공유 링크 : http://boj.kr/8154b552e3be4ad7a6a2998242c7b7f1
// 백준 터렛

// c 언어를 공부하기 위해서 풀고 있는 문제 (기하1)

/*
..? 어떤 해결방식을 보고 싶어서 이런 문제가 있는지 잘 모르겠다.
그냥 조건문 문제로 보이는데 기하문제라고 쓰여있다.
*/

#include <stdio.h>
#include <math.h>

int main(){  
  int t;
  scanf("%d", &t);

  int x1, y1, r1, x2, y2, r2;
  for (int i = 0; i < t; i++)
  {
    scanf("%d %d %d %d %d %d", &x1, &y1, &r1, &x2, &y2, &r2);

    // 두 원의 중점 사이 거리
    double diff = sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    // 계산을 쉽게하기 위해서 반지름 r1이 항상 r2보다 더 큰 값으로 만든다.
    if (r1 < r2)
    {
      int temp = r1;
      r1 = r2;
      r2 = temp;
    }
    
    if (x1 == x2 && y1 == y2 && r1 == r2){
      // 두 원의 중점과 반지름이 같을 때 만나는 지점이 무한이다.
      printf("-1");
      
    }else if(diff > r1 + r2){
      // 두 원의 중점사이의 거리가 두 반지름의 합보다 크다면 두 원은 만나지 않는다.
      printf("0");
    }else if(diff == r1 + r2){
      // 두 원의 중점사이의 거리가 두 반지름의 합과 같다면 두 원은 한 점에서 만난다.
      printf("1");

    }else{ // diff < r1 + r2
      // 두 원의 중점 사이의 거리가 두 반지름의 합보다 작을 때
      if (diff + r2 > r1)
      {
        // 더 큰 반지름이 중점 사이의 거리와 작은 반지름의 합보다 
        // 작으면 두 점에서 만나고
        printf("2");
      }else if(diff + r2 == r1){
        // 같으면 한 점에서 만나고
        printf("1");
      }else{
        // 크면 만나지 않는다.
        printf("0");
      }
    }
    printf("\n");
  }

  return 0;
}