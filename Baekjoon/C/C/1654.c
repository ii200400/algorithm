// 문제 링크 : https://www.acmicpc.net/problem/1654
// 제출 공유 링크 : http://boj.kr/cad139d5f16b42d6979e404d13618a82
// 백준 랜선 자르기

// c 언어를 공부하기 위해서 풀고 있는 문제 (이분 탐색)

/*
예전부터 알고 있던 아주 대표적인 이분탐색 문제
항상 이분탐색 하면 범위가 햇갈려서 c언어로도 한 번 구현해보겠다.

앗.. 랜선길이가 2^31-1 인 것을 너무 늦게 보았다..
*/

#include <stdio.h>
#include <stdlib.h>

int main(){
  // 가진 랜선의 수, 필요한 랜선의 개수
  int k, n;
  scanf("%d %d", &k, &n);

  // 랜선의 길이 배열 생성 및 초기화
  int *lengths = (int *)malloc(sizeof(int) * k);
  // 이분탐색할 때 탐색을 위한 랜선 길이
  long left = 1, right = 0;  // 최소 랜선길이와 정답이 될 수 없는 랜선 길이
  for (int i = 0; i < k; i++)
  {
    scanf("%d", &lengths[i]);
    // right 변수에는 가지고 있는 랜선 중 가장 길 랜선에서
    if (right < lengths[i])
    {
      right = lengths[i];
    }
  }
  // +1을 하여 정답이 될 수 없는 랜선길이로 만들어준다.
  right++;

  // 이진탐색 시작
  long mid, sum;
  while(left + 1 != right){
    mid = (left + right) / 2; // 자를 길이
    sum = 0;  // mid 만큼 잘랐을 때의 랜선의 수

    // mid 만큼 잘랐을 때
    for (int i = 0; i < k; i++)
    {
      sum += lengths[i] / mid;
    }

    // printf("%d %d\n", mid, sum);
    
    // 원하는 개수보다 많거나 같다면 left에
    if (sum >= n)
      left = mid;
    else  // 그렇지 않다면 right에 넣어준다.
      right = mid;
  }

  // 이진탐색을 통해서 구한 N개를 만들 수 있는 랜선의 최대 길이 출력
  printf("%d", left);

  return 0;
}