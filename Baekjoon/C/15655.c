// 문제 링크 : https://www.acmicpc.net/problem/15655
// 제출 공유 링크 : http://boj.kr/a61ab7eabc01421a83021515c467e7f3
// 백준 N과 M (6)

// c 언어를 공부하기 위해서 풀고 있는 문제 (조합)

/*
여러 개의 수 중 특정 개수만 뽑는 조합문제
입력받는 수가 정렬이 되어있지 않아서 먼저 정렬을 진행해주어야 한다.
*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

void quicksort(int *arr, int from, int to);
void combination(int *arr, int size, int idx, int *selected_arr, int selected_size, int selected_idx);

int main(){
  // 자연수의 수, 뽑는 숫자 수
  int n, m;
  scanf("%d %d", &n, &m);

  // 숫자 배열 초기화
  int *arr = (int *)malloc(sizeof(int) * n);
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &arr[i]);
  }

  quicksort(arr, 0, n-1);
  // 디버깅용
  // for (int i = 0; i < n; i++)
  // {
  //   printf("%d ", arr[i]);
  // }
  // printf("\n");

  // 숫자 배열의 조합을 담을 배열
  int *comb = (int *)malloc(sizeof(int) * m);
  combination(arr, n, 0, comb, 0, m);

  return 0;
}

void quicksort(int *arr, int from, int to){
  int mode = -1;
  int left_idx = from, right_idx = to;

  while (left_idx != right_idx)
  {
    if (arr[left_idx] > arr[right_idx])
    {
      int temp = arr[left_idx];
      
      arr[left_idx] = arr[right_idx];
      arr[right_idx] = temp;
      mode *= -1;
    }

    if (mode == -1)
    {
      right_idx--;
    }else{
      left_idx++;
    }
  }

  if (from + 1 < left_idx)
  {
    quicksort(arr, from, left_idx - 1);
  }else if(left_idx < to - 1){
    quicksort(arr, left_idx+1, to);
  }
}

// 주어진 숫자배열에서 가능한 num개를 선택하여 만들 수 있는 모든 조합을 출력하는 함수
// 숫자 배열, 배열의 크기, 탐색할 숫자 배열의 인덱스, 조합 배열, 조합 배열 인덱스, 조합 배열 크기
void combination(int *arr, int size, int idx, int *selected_arr, int selected_size, int selected_idx){
  if (selected_idx == selected_size)
  {
    for (int i = 0; i < selected_size; i++)
    {
      printf("%d ", selected_arr[i]);
    }
    printf("\n");

    return;
  }
  

  for (int i = idx; i < size; i++)
  {
    selected_arr[selected_idx] = arr[i];
    combination(arr, size, i + 1, selected_arr, selected_size, selected_idx + 1);
  }
  
}