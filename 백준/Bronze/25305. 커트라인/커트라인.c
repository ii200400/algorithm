#include <stdio.h>
#include <stdlib.h>

void insertSort(int *arr, int size);

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

  insertSort(x, n);

  // 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수 출력
  printf("%d", x[k-1]);

  free(x);

  return 0;
}

// 삽입정렬
void insertSort(int *arr, int size){
  // 위치를 찾고자하는 숫자를 임시 저장할 변수
  int temp;
  for (int i = 1; i < size; i++)
  {
    // i번째 숫자를 임시 저장
    temp = arr[i];

    // i 번째 이전의 숫자들을 탐색하면서 i번째 숫자가 들어갈 위치 확인
    int j = i - 1;
    for (; j >= 0; j--)
    {
      // (오름차순이므로) 더 큰 숫자가 나오면 for문 탈출
      if (temp <= arr[j])
      {
        break;
      }

      // 그렇지 않다면 이미 수를 왼쪽으로 1칸 이동
      arr[j + 1] = arr[j];
    }

    // 큰 수의 이전 인덱스에 숫자 저장
    arr[j + 1] = temp;
  }
}