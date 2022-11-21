#include <stdio.h>
#include <stdlib.h>

void quicksort(int *arr, int from, int to);
void combination(int *arr, int size, int idx, int *selected_arr, int selected_idx, int selected_size);

int main(){
  // 자연수의 수, 뽑는 숫자 수
  int n, m;
  scanf("%d %d", &n, &m);

  // 숫자 배열 초기화
  int *arr = (int *)malloc(sizeof(int) * n);
  for (int i = 0; i < n; i++)
  {
    arr[i] = i+1;
  }

  // 숫자 배열의 조합을 담을 배열
  int *comb = (int *)malloc(sizeof(int) * m);
  combination(arr, n, 0, comb, 0, m);

  return 0;
}

// 주어진 숫자배열에서 가능한 num개를 선택하여 만들 수 있는 모든 조합을 출력하는 함수
// 숫자 배열, 배열의 크기, 탐색할 숫자 배열의 인덱스, 조합 배열, 조합 배열 인덱스, 조합 배열 크기
void combination(int *arr, int size, int idx, int *selected_arr, int selected_idx, int selected_size){
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
    combination(arr, size, i + 1, selected_arr, selected_idx + 1, selected_size);
  }
  
}