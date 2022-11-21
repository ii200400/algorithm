#include <stdio.h>
#include <stdlib.h>

void swap(int *a, int *b);
void quickSort(int *arr, int left, int right);

int main(){
  int n;
  scanf("%d", &n);

  // 정렬을 진행할 배열 동적할당, stdlib 사용
  int *x = (int *)malloc(sizeof(int) * n);
  // 배열 x 초기화
  for (int i = 0; i < n; i++)
  {
    scanf("%d", &x[i]);
  }

  quickSort(x, 0, n-1);

  // 점수 출력
  for (int i = 0; i < n; i++)
  {
    printf("%d\n", x[i]);
  }

  free(x);

  return 0;
}

// a와 b의 숫자를 바꿔준다.
void swap(int *a, int *b){
  int temp = *a;
  *a = *b;
  *b = temp;
}

// 퀵소트, 기준이 되는 숫자(기준값)는 arr[left]
// 정렬할 배열, 왼쪽 범위, 오른쪽 범위 (left <= <= right)
void quickSort(int *arr, int left, int right){
  // 임시로 저장할 왼쪽과 오른쪽 포인터
  int temp_left = left, temp_right = right;

  // -1이면 오른쪽 포인터를 왼쪽으로 한칸 (arr[temp_left]에 기준값이 있다.)
  // 1이면 왼쪽 포인터를 오른쪽으로 한칸 (이 때는 arr[temp_right]에 기준값이 있다.)
  // 움직이도록 하여 오름차순을 만들기 위한 변수
  int move = -1;

  // 기준값이 자리를 찾을 때(temp_left == temp_right)까지 반복한다.
  while (temp_left != temp_right)
  {
    // 기준값과 비교하여 오름차순이 맞지 않다면
    if (arr[temp_left] > arr[temp_right]){
      // 두 수를 바꿔주고 move 변수를 조작한다.
      swap(&arr[temp_left], &arr[temp_right]);
      move *= -1;
    }

    // move 변수에 맞게 포인터를 이동시켜준다.
    if (move == 1)
    {
      temp_left++;
    }else{
      temp_right--;
    }
  }
  
  // 위의 방법으로 모든 숫자가 자리를 찾을 때 까지 반복한다.
  if (left < temp_left - 1) {
    quickSort(arr, left, temp_left - 1);
  }
  if (temp_left + 1 < right) {
    quickSort(arr, temp_left + 1, right);
  }
}