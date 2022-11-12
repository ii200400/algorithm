#include <stdio.h>
#include <stdlib.h>

void swap(int *a, int *b);
void bubbleSort(int *arr, int size);

int main(){
  // 사람 수, 상을 받는 사람 수
  int n, k;
  scanf("%d %d", &n, &k);

  // 정렬을 진행할 배열 동적할당, stdlib 사용
  int *x = (int *)malloc(sizeof(int) * n);
  // 배열 x 초기화
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &x[i]);
  }

  // selectionSort(x, n);
  // insertSort(x, n);
  bubbleSort(x, n);

  // 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수 출력
  printf("%d", x[k-1]);

  free(x);

  return 0;
}

// a와 b의 숫자를 바꿔준다.
void swap(int *a, int *b){
  int temp = *a;
  *a = *b;
  *b = temp;
}

// 버블정렬
void bubbleSort(int *arr, int size){
  for (int i = size-1; i > 0; i--)
  {

    for (int j = 0; j < i; j++)
    {
      if (arr[j] < arr[j+1])
      {
        swap(&arr[j], &arr[j + 1]);
      }
    }
  }
}