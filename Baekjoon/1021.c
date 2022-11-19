// 문제 링크 : https://www.acmicpc.net/problem/1021
// 제출 공유 링크 : http://boj.kr/ca5b3d9818da4bbea7d826b675c566cf
// 백준 회전하는 큐

// c 언어를 공부하기 위해서 풀고 있는 문제 (큐, 덱)

/*
스택도 구현했고 큐도 구현했으니 덱도 구현해보려고 한다.
문제를 보아하니.. 아마? 환형 데큐이다. 
할 수 있을지 모르겠는데 이해하는데로 구현하겠다.
*/

#include <stdio.h>
#include <stdlib.h>

// 데큐에 들어가는 노드
struct node{
  int num;  // 노드가 가지는 수
  struct node *next;  // 해당 노드의 다음(더 최근에 들어간) 노드
  struct node *before;  // 해당 노드의 이전(더 먼저 들어간) 노드
};

// 데큐 구조체, 크기가 0인 상태에서 pop하는 경우가 없어서 size는 만들지 않았다.
struct deque{
  struct node *point; //현재 보고있는 노드 포인터
};

void deque_init(struct deque *dq, int num);
int search_num(struct deque *dq, int num);

int main(){
  // 큐의 크기, 뽑아내려고 하는 수의 개수
  int n, m;
  scanf("%d %d", &n, &m);

  // 데큐 초기화
  struct deque dq;
  deque_init(&dq, n);

  // m개의 수 뽑기
  int search;
  int sum = 0;  // 연산의 최소 회수
  for (int i = 0; i < m; i++)
  {
    scanf("%d", &search);
    // 데큐에서 search 수를 찾기까지의 최소 연산수 구하고 
    // sum에 더해준다.
    sum += search_num(&dq, search);
  }

  // 연산의 최소 회수 출력
  printf("%d", sum);

  return 0;
}

// 데큐 초기화, num개의 노드를 만들어 초기화한다.
void deque_init(struct deque *dq, int num){
  // 먼저 넣은 노드, 다음 노드로 n2를 가리킨다.
  struct node *n1 = (struct node *)malloc(sizeof(struct node));
  n1->num = 1;
  dq->point = n1;

  // 다음에 넣을 노드, 이전노드로 n1을 가리킨다.
  struct node *n2 = n1; // num이 1일 때를 대비하여
  for (int i = 2; i <= num; i++)
  {
    // 새 노드를 만들고
    n2 = (struct node *)malloc(sizeof(struct node));
    // 두 노드를 이어준다.
    n2->num = i;
    n2->before = n1;
    n1->next = n2;

    n1 = n2;
  }

  // 마지막으로 가장 먼저 노드와 가장 나중에 넣은 노드를 연결한다.
  dq->point->before = n2;
  n2->next = dq->point;
}

// 데큐에서 특정 수를 찾고 찾기까지의 최소 연산 수를 반환하는 함수
int search_num(struct deque *dq, int num){
  // 현재 데큐가 기억하는 포인트 위치에서 앞, 뒤로 탐색하기 위한 포인터 둘
  struct node *to_next = dq->point;
  struct node *to_before = dq->point;

  // num을 찾을 때까지 반복
  int min = 0;
  while(1){
    // 앞으로 탐색하는 포인터가 찾았을 때
    if (to_next->num == num)
    {
      dq->point = to_next;
      break;
    }else if(to_before->num == num)
    { // 뒤로 탐색하는 포인터가 찾았을 때
      dq->point = to_before;
      break;
    }

    // 아직 못찾았다면 다음 노드를 살펴본다.
    to_next = to_next->next;
    to_before = to_before->before;
    min++;
  }

  // 찾은 수를 데큐에서 제외시키고
  struct node *temp = dq->point->next;
  dq->point->before->next = dq->point->next;
  dq->point->next->before = dq->point->before;
  free(dq->point);

  // 찾은 노드의 다음 노드를 데큐의 포인터가 가리키는 노드로 한다.
  dq->point = temp;

  // 수를 찾을 때까지 얼마나 연산이 필요한지 반환한다.
  // printf("%d\n", min);
  return min;
}