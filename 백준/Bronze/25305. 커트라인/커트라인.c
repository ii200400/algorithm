#include <stdio.h>
#include <stdlib.h>

void selectionSort(int *arr, int size);
void swap(int *a, int *b);

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

  selectionSort(x, n);

  // 디버깅용
  // for (int i = 0; i < n; i++)
  // {
  //   printf("%d ", x[i]);
  // }
  

  // 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수 출력
  printf("%d", x[k-1]);

  free(x);

  return 0;
}

// 선택정렬
void selectionSort(int *arr, int size){
  // 남은 숫자중 가장 큰 수, 남은 숫자 중 가장 큰 수의 인덱스
  int max, idx;

  // 오름차순 정렬
  for (int i = 0; i < size; i++)
  {
    // 초기화
    max = arr[i];
    idx = i;

    // 이미 정렬된 숫자를 제외하고 i번째에 넣을 최대 값을 찾는다.
    for (int j = i+1; j < size; j++)
    {
      if (max < arr[j])
      {
        max = arr[j];
        idx = j;
      }
    }

    // i 번째에 지금 넣을 수 있는 최대 값을 넣는다.
    swap(&arr[i], &arr[idx]);
  }
}

// a와 b의 숫자를 바꿔준다.
void swap(int *a, int *b){
  int temp = *a;
  *a = *b;
  *b = temp;
}