// 문제 링크 : https://www.acmicpc.net/problem/25305
// 제출 공유 링크(선택) : http://boj.kr/bdb802d221814eb1bd237b24ee299083
// 제출 공유 링크(삽입) : http://boj.kr/4128908728f84775ac017022a30c3365
// 제출 공유 링크(버블) : http://boj.kr/2e6a84093e414998914a523ae4981ed9
// 제출 공유 링크(퀵) : http://boj.kr/c89a419b3c7f4e2899fee65d62e73d87
// 제출 공유 링크(병합) : http://boj.kr/cade08edfd4142b993ec96bed1f3f5b0

// 백준 커트라인

// c 언어를 공부하기 위해서 풀고 있는 문제 (정렬)

/*
정렬 종류별로 한 개씩 만들어보려고 한다.
그런데 아직.. 함수 파라미터 넘기는 것도 익숙하지 않아서..
선택정렬, 삽입정렬, 버블정렬은 꼭 작성하고
퀵정렬, 합병정렬, 힙정렬은 나중에 작성해보려고 한다.

참고한 곳은 https://www.codeground.org/common/popCodegroundNote

종류만 찾으려고 했는데 너무 잘 정리한 블로그를 찾았다..
https://medium.com/@joongwon/%EC%A0%95%EB%A0%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B8%B0%EC%B4%88-805391cb088e
구현하고 읽어봐야겠다.
*/

#include <stdio.h>
#include <stdlib.h>

void selectionSort(int *arr, int size);
void swap(int *a, int *b);
void insertSort(int *arr, int size);
void bubbleSort(int *arr, int size);
void quickSort(int *arr, int left, int right);
void mergeSort(int *arr, int *tempArr, int left, int right);
void merge(int *arr, int *tempArr, int left, int mid, int right);

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
  // bubbleSort(x, n);
  // quickSort(x, 0, n);
  // 합병정렬을 위한 임시 배열
  int *tempArr = (int *)malloc(sizeof(int) * n);
  mergeSort(x, tempArr, 0, n);

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

// 퀵소트, 기준이 되는 숫자(기준값)는 arr[left]
// 정렬할 배열, 왼쪽 범위, 오른쪽 범위
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
    if (arr[temp_left] < arr[temp_right]){
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

// 병합정렬
// 정렬할 배열, 임시 저장용 배열, 정렬할 범위 왼쪽 / 오른쪽
void mergeSort(int *arr, int *tempArr, int left, int right){
  // 범위를 절반으로 나누어
  int mid = (left + right) / 2;

  // 왼쪽의 정렬을 진행하고
  if (left < mid)
  {
    mergeSort(arr, tempArr, left, mid);
  }
  // 오른쪽의 정렬을 진행하고
  if (mid+1 < right)
  {
    mergeSort(arr, tempArr, mid+1, right);
  }

  // 정렬된 왼쪽과 오른쪽을 합치면서 정렬을 진행한다.
  merge(arr, tempArr, left, mid, right);
}

// 정렬된 두 부분(left~mid, mid+1~right)을 하나로 합치는 함수
void merge(int *arr, int *tempArr, int left, int mid, int right){
  // 왼쪽 부분과 오른쪽 부분의 인덱스
  int idxL = left, idxR = mid + 1;
  // 두 부분을 병합할 배열의 인덱스
  int idxTemp = left;

  while(1){
    // 오름차순이므로 두 부분 중 더 큰 값을 배열에 넣어준다.
    if (arr[idxL] > arr[idxR])
    {
      tempArr[idxTemp++] = arr[idxL++];
      
      // 왼쪽 부분에서 더 이상 옮길 숫자가 없다면 반복문을 나간다.
      if (idxL > mid)
        break;
    }else{
      tempArr[idxTemp++] = arr[idxR++];

      // 오른쪽 부분에서 더 이상 옮길 숫자가 없다면 반복문을 나간다.
      if (idxR > right)
        break;
    }
  }

  // 미관상 여기에 작성
  // 왼쪽 부분의 남은 숫자가 있다면 모두 옮겨준다.
  while(idxL <= mid){
    tempArr[idxTemp++] = arr[idxL++];
  }
  // 오른쪽 부분의 남은 숫자가 있다면 모두 옮겨준다.
  while(idxR <= right){
    tempArr[idxTemp++] = arr[idxR++];
  }
  
  // 정렬을 위한 임시배열에 있던 내용을 기존 배열로 옮긴다.
  for (int i = left; i <= right; i++)
  {
    arr[i] = tempArr[i];
  }
}