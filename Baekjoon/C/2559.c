// 문제 링크 : https://www.acmicpc.net/problem/2559
// 제출 공유 링크 : http://boj.kr/be4f8570d82340e4a5bcc0a7ba85d7c8
// 백준 수열

// c 언어를 공부하기 위해서 풀고 있는 문제 (누적 합)

/*

*/

#include <stdio.h>
#include <stdlib.h>

int main(){
  // 온도를 측정한 전체 날짜의 수, 합을 구하기 위한 연속적인 날짜의 수
  int n, k;
  scanf("%d %d", &n, &k);

  // 온도의 수열, 첫번째 수는 계산을 위해서 0으로 한다.
  int *arr = (int *)malloc(sizeof(int) * (n + 1));
  // 연속적인 K일의 온도 합, 연속적인 K일의 온도의 합 최대
  int sum = 0, max = -10000001;

  // 온도의 수열 초기화 및 온도 계산
  arr[0] = 0;
  for (int i = 1; i < n+1; i++)
  {
    // 수 입력
    scanf("%d", &arr[i]);

    // 수가 k번째 이하라면 그냥 합산만을 하고
    if (i < k)
    {
      sum += arr[i];
    }else{  // k번째 이후부터는 최대값인지 확인해준다.
      sum += arr[i] - arr[i - k];
      if (sum > max)
      {
        max = sum;
      }
    }
  }

  // 연속적인 K일의 온도의 합 최대값 출력
  printf("%d", max);

  return 0;
}